package br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.impl;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter.CompanionAdapter;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.CompanionRequest;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.CompanionResponse;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.CompanionsGateway;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.SaveCompanion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveCompanionImpl implements SaveCompanion {

    private final CompanionsGateway companionsGateway;

    @Override
    public CompanionResponse execute(CompanionRequest request) {
        return companionsGateway.saveCompanionOnClient(CompanionAdapter.convert(request));
    }
}
