package br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.CompanionResponse;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Companion;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.SaveCompanionResponse;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

@UtilityClass
public class CompanionResponseAdapter {

    public static CompanionResponse convert(SaveCompanionResponse response) {
        var companionResponse = CompanionResponse.builder().build();
        BeanUtils.copyProperties(response, companionResponse);
        companionResponse.setVisitInfo(response.getVisitInfo());
        return companionResponse;

    }

    public static CompanionResponse convert(Companion companion) {
        var companionResponse = CompanionResponse.builder().build();
        BeanUtils.copyProperties(companion, companionResponse);
        companionResponse.setVisitInfo(companion.getVisitInfo());
        return companionResponse;
    }
}
