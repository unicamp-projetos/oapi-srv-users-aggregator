package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanionDatabaseResponse {
    @NonNull
    @JsonProperty("nome")
    private String name;
    @NonNull
    private Long cpf;
    private String rg;
    @JsonProperty("hora_de_chegada")
    private LocalDateTime arrivalTime;
    @JsonProperty("visitando")
    private Boolean isVisiting;
}
