package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

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
}
