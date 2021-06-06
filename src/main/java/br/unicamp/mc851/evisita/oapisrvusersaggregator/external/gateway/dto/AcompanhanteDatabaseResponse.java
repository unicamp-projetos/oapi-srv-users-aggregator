package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AcompanhanteDatabaseResponse {
    @NonNull
    private String nome;
    @NonNull
    private Long cpf;
    private Long rg;
}
