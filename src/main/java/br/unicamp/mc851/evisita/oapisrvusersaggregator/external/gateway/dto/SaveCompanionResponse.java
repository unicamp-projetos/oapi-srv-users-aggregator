package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaveCompanionResponse {
    private List<Long> patientsId;
    private String name;
    private Boolean isVisiting;
    private LocalDateTime arrivalTime;
}
