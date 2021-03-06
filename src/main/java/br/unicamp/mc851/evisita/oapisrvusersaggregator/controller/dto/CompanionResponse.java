package br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanionResponse {
    private String name;
    private String cpf;
    private LocalDateTime arrivalTime;
    private Boolean isVisiting;
}
