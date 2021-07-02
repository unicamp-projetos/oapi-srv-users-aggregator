package br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class VisitInfoResponse {
    private LocalDateTime arrivalTime;
    private LocalDateTime exitTime;
    private Boolean isVisiting;
    @EqualsAndHashCode.Include
    private String patientId;
}
