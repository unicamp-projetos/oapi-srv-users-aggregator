package br.unicamp.mc851.evisita.oapisrvusersaggregator.domain;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Acompanhante {
    @NonNull
    private String nome;
    @NonNull
    private Long cpf;
    private Long rg;
    @NonNull
    private List<Long> idPacientes;
}
