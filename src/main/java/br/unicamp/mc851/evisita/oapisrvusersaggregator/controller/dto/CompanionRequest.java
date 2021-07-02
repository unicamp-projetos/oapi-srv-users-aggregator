package br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.VisitInfo;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanionRequest {
    @NonNull
    private String name;
    @NonNull
    private String cpf;
    private String rg;
    @NonNull
    private List<VisitInfo> visitInfo;
}
