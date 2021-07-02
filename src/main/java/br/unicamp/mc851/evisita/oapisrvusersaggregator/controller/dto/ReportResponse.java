package br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportResponse {
    private String name;
    private String cpf;
    private List<VisitInfoResponse> visitInfoResponse;
}
