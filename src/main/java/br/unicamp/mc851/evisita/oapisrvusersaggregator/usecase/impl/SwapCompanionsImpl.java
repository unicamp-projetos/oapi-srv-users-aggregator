package br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.impl;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.constant.Constants;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.CompanionRequest;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.VisitInfo;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.CheckIfPatientExists;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.SaveCompanion;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.SwapCompanions;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.UpdateVisitingCompanion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.TemporalAmount;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SwapCompanionsImpl implements SwapCompanions {

    private final CheckIfPatientExists checkIfPatientExists;
    private final UpdateVisitingCompanion updateVisitingCompanion;
    private final SaveCompanion saveCompanion;

    @Override
    public Boolean execute(CompanionRequest currentCompanion, CompanionRequest newCompanion) {
        if (!newCompanion.getVisitInfo().equals(currentCompanion.getVisitInfo())) {
            return false;
        }

        var validIds = newCompanion.getVisitInfo()
                .parallelStream()
                .filter(visitInfo -> checkIfPatientExists.execute(visitInfo.getPatientId()))
                .collect(Collectors.toList());

        currentCompanion.getVisitInfo().stream()
                .filter(visitInfo -> validIds.contains(visitInfo.getPatientId()))
                .map(this::getVisitInfo);

        var updated = CompletableFuture.supplyAsync(() ->
                updateVisitingCompanion.execute(currentCompanion));
        var saved = CompletableFuture.supplyAsync(() ->
                saveCompanion.execute(newCompanion));

        saved.join();
        updated.join();

        return true;
    }

    private VisitInfo getVisitInfo(VisitInfo visitInfo) {
        visitInfo.setIsVisiting(false);
        visitInfo.setExitTime(LocalDateTime.now().minus(
                Duration.between(visitInfo.getArrivalTime(), LocalDateTime.now())));
        return visitInfo;
    }
}
