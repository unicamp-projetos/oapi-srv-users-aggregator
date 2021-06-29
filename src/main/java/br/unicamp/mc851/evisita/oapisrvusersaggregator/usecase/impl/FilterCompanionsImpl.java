package br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.impl;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter.CompanionAdapter;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Companion;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.PatientDatabaseResponse;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.FilterCompanions;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FilterCompanionsImpl implements FilterCompanions {
    @Override
    public List<Companion> execute(
            List<PatientDatabaseResponse> patientDatabaseResponses,
            Set<Long> patientsId) {
        List<Companion> companions = new ArrayList<>();
        patientDatabaseResponses.stream()
                .filter(pDR -> patientsId.contains(pDR.getMedicalRecord()))
                .forEach(pDR -> {
                    companions.addAll(CompanionAdapter.convert(pDR));
                });
        return combinePatientsIds(companions);
    }

    private List<Companion> combinePatientsIds(List<Companion> companions) {
        Map<Long, Integer> uniqueCompanion = new HashMap<>();
        List<Integer> removeIndexes = new ArrayList<>();
        for (int i = 0; i < companions.size(); i++) {
            Integer prevIndex = uniqueCompanion.putIfAbsent(companions.get(i).getCpf(), i);
            if (prevIndex != null) {
                companions.get(prevIndex).getPatientsId().addAll(companions.get(i).getPatientsId());
                removeIndexes.add(i);
            }
        }
        removeIndexes.forEach(companions::remove);
        return companions;
    }
}
