package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.impl;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter.CompanionToSaveCompanionRequest;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter.SaveCompanionResponseToCompanionResponse;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.CompanionResponse;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Companion;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.SaveCompanionOnClient;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.client.OapiSrvCompanionsClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SaveCompanionOnClientImpl implements SaveCompanionOnClient {

    private final OapiSrvCompanionsClient client;

    @Override
    public CompanionResponse execute(Companion companion) {
        try {
            return SaveCompanionResponseToCompanionResponse.convert(
                    client.execute(CompanionToSaveCompanionRequest.convert(companion)));
        } catch (FeignException e) {
            log.info("Companion {} was not registered on database.", companion.getName());
            return null;
        }
    }
}
