package br.unicamp.mc851.evisita.oapisrvusersaggregator.domain;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class VisitInfo {
    @EqualsAndHashCode.Include
    private String patientId;
    private LocalDateTime arrivalTime;
    private LocalDateTime exitTime;
    private Boolean isVisiting;
}
