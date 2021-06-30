package br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportResponse {
    private String companionName;
    private String cpf;
    private LocalDateTime arrivalTime;
    private LocalDateTime exitTime;
    private Boolean isVisiting;
}
