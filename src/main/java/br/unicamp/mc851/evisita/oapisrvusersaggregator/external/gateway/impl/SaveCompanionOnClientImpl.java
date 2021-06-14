package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.impl;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter.CompanionToSaveCompanionRequest;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter.SaveCompanionResponseToCompanionResponse;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.CompanionResponse;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Companion;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.SaveCompanionOnClient;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.client.OapiSrvCompanionsClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveCompanionOnClientImpl implements SaveCompanionOnClient {

    private final OapiSrvCompanionsClient client;

    @Override
    public CompanionResponse execute(Companion companion) {
        return SaveCompanionResponseToCompanionResponse.convert(
            client.execute(CompanionToSaveCompanionRequest.convert(companion)));
    }
}
