package br.unicamp.mc851.evisita.oapisrvusersaggregator.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Companion {
    private String name;
    private Long cpf;
    private String rg;
    private List<Long> patientsId;
    private LocalDateTime arrivalTime;
    private Boolean isVisiting;
}
