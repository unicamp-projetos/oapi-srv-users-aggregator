package br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.constant.Constants;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.CompanionResponse;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.ReportResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ReportAdapter {

    public static ReportResponse convert(CompanionResponse companionResponse) {
        return ReportResponse.builder()
                .arrivalTime(companionResponse.getArrivalTime())
                .cpf(companionResponse.getCpf())
                .isVisiting(companionResponse.getIsVisiting())
                .companionName(companionResponse.getName())
                .exitTime(companionResponse.getArrivalTime().plusHours(Constants.TIME_OF_VISITING))
                .build();
    }
}
