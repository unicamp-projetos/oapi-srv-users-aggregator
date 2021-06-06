package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto;

import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDatabaseResponse {
    @NonNull
    private Long prontuario;
    @NonNull
    private String nome;
    private String nomeMae;
    private String nomePai;
    @NonNull
    private Long cpf;
    private Long rg;
    private Long nroCartaoSaude;
    @NonNull
    private String medico;
    private List<AcompanhanteDatabaseResponse> acompanhantes;
}
