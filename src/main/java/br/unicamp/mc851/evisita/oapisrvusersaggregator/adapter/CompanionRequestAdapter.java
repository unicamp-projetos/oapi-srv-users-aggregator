package br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.CompanionRequest;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Companion;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

@UtilityClass
public class CompanionRequestAdapter {

    public static CompanionRequest convert(Companion companion) {
        var companionRequest = CompanionRequest.builder().build();
        BeanUtils.copyProperties(companion, companionRequest);
        companionRequest.setVisitInfo(companion.getVisitInfo());
        return companionRequest;
    }
}
