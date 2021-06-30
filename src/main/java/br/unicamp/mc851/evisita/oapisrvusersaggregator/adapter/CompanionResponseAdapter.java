package br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.CompanionResponse;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Companion;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.SaveCompanionResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CompanionResponseAdapter {

    public static CompanionResponse convert(SaveCompanionResponse response) {
        return CompanionResponse.builder()
                .name(response.getName())
                .isVisiting(response.getIsVisiting())
                .arrivalTime(response.getArrivalTime())
                .cpf(response.getCpf())
                .build();
    }

    public static CompanionResponse convert(Companion companion) {
        return CompanionResponse.builder()
                .name(companion.getName())
                .isVisiting(companion.getIsVisiting())
                .arrivalTime(companion.getArrivalTime())
                .cpf(companion.getCpf())
                .build();
    }
}
