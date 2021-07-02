package br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.constant.Constants;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.CompanionResponse;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.ReportResponse;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@UtilityClass
public class ReportAdapter {

    public static ReportResponse convert(CompanionResponse companionResponse) {
        var reportResponse = ReportResponse.builder().build();
        BeanUtils.copyProperties(companionResponse, reportResponse);
        BeanUtils.copyProperties(companionResponse.getVisitInfo(), reportResponse.getVisitInfoResponse());
        reportResponse.getVisitInfoResponse().forEach(vIR ->
                vIR.setExitTime(LocalDateTime.of(LocalDate.now(),
                        LocalTime.now().plusHours(Constants.PERIOD_IN_HOURS_OF_VISIT))));
        return reportResponse;

    }
}
