package br.unicamp.mc851.evisita.oapisrvusersaggregator.domain;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Companion {
    @NonNull
    private String name;
    @NonNull
    private Long cpf;
    private String rg;
    @NonNull
    private List<Long> idPatients;
}
