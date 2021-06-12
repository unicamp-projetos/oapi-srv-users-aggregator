package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto;

import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDatabaseResponse {
    @NonNull
    private Long prontuario;
    @NonNull
    private String nome;
    private String nome_mae;
    private String nome_pai;
    @NonNull
    private Long cpf;
    private String rg;
    private Long nro_cartao_saude;
    @NonNull
    private String medico;
    private List<CompanionDatabaseResponse> acompanhantes;
}
