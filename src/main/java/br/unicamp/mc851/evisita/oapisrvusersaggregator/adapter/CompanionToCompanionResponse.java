package br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.CompanionResponse;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Companion;

public class CompanionToCompanionResponse {

    private CompanionToCompanionResponse() {}

    public static CompanionResponse convert(Companion companion) {
        return CompanionResponse.builder()
                .name(companion.getName())
                .build();
    }
}
