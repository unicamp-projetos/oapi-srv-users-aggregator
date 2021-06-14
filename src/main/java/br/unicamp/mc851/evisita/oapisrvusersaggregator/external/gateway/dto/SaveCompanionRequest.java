package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaveCompanionRequest {
    @NonNull
    private Long cpf;
    private String rg;
    @NonNull
    private String name;
    @NonNull
    private List<Long> patientsId;
}
