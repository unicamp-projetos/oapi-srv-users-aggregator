package br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.CompanionRequest;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Companion;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.SaveCompanionRequest;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

@UtilityClass
public class SaveCompanionRequestAdapter {

    public static SaveCompanionRequest convert(Companion companion) {
        var saveCompanionRequest = SaveCompanionRequest.builder().build();
        BeanUtils.copyProperties(companion, saveCompanionRequest);
        saveCompanionRequest.setVisitInfo(companion.getVisitInfo());
        return saveCompanionRequest;
    }

    public static SaveCompanionRequest convert(CompanionRequest request) {
        var saveCompanionRequest = SaveCompanionRequest.builder().build();
        BeanUtils.copyProperties(request, saveCompanionRequest);
        saveCompanionRequest.setVisitInfo(request.getVisitInfo());
        return saveCompanionRequest;
    }
}
