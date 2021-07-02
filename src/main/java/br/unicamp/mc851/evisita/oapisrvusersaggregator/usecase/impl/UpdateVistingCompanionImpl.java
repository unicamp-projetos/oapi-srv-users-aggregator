package br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.impl;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter.CompanionAdapter;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.CompanionRequest;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.CompanionsGateway;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.UpdateVisitingCompanion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateVistingCompanionImpl implements UpdateVisitingCompanion {

    private final CompanionsGateway gateway;

    @Override
    public Boolean execute(CompanionRequest request) {
        return gateway.updateCompanion(CompanionAdapter.convert(request)).getStatusCode().is2xxSuccessful();
    }
}
