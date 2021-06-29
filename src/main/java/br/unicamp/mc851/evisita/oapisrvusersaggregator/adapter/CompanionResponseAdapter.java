package br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.CompanionResponse;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Companion;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.SaveCompanionResponse;

public class CompanionResponseAdapter {

    private CompanionResponseAdapter() {}

    public static CompanionResponse convert(SaveCompanionResponse response) {
        return CompanionResponse.builder()
                .name(response.getName())
                .build();
    }

    public static CompanionResponse convert(Companion companion) {
        return CompanionResponse.builder()
                .name(companion.getName())
                .build();
    }
}
