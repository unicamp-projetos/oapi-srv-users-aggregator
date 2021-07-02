package br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.CompanionRequest;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Companion;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.VisitInfo;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.CompanionDatabaseResponse;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.PatientDatabaseResponse;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class CompanionAdapter {

    public static Companion convert(CompanionDatabaseResponse response, String patientId) {
        var companion = Companion.builder().build();
        BeanUtils.copyProperties(response, companion);
        companion.setVisitInfo(List.of(VisitInfo.builder()
                .isVisiting(response.getIsVisiting())
                .arrivalTime(response.getArrivalTime())
                .patientId(patientId)
                .build()));
        return companion;
    }

    public static Companion convert(CompanionRequest request) {
        var companion = Companion.builder().build();
        BeanUtils.copyProperties(request, companion);
        companion.setVisitInfo(request.getVisitInfo());
        return companion;
    }

    public static List<Companion> convert(PatientDatabaseResponse response) {
        return response.getCompanions()
                .stream()
                .map(cDR -> CompanionAdapter.convert(cDR, response.getMedicalRecord()))
                .collect(Collectors.toList());
    }
}
