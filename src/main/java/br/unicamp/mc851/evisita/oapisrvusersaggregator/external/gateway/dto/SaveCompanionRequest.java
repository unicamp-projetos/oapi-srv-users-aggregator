package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaveCompanionRequest {
    @NonNull
    private String cpf;
    private String rg;
    @NonNull
    private String name;
    @NonNull
    private List<String> patientsId;
    private LocalDateTime arrivalTime;
    @NonNull
    private Boolean isVisiting;
}
