package br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.CompanionResponse;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Companion;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.SaveCompanionResponse;

public class SaveCompanionResponseToCompanionResponse {

    private SaveCompanionResponseToCompanionResponse() {}

    public static CompanionResponse convert(SaveCompanionResponse response) {
        return CompanionResponse.builder()
                .name(response.getName())
                .build();
    }
}
