package br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.impl;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Companion;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.CompanionsGateway;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.UpdateCompanions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UpdateCompanionsImpl implements UpdateCompanions {

    private final CompanionsGateway companionsGateway;

    @Override
    public void execute(List<Companion> companions) {
        companions.forEach(companionsGateway::execute);
    }
}
