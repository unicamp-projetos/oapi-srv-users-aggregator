package br.unicamp.mc851.evisita.oapisrvusersaggregator.domain;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
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
    private List<Acompanhante> acompanhantes;
}
