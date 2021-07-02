package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.VisitInfo;
import lombok.*;

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
    private List<VisitInfo> visitInfo;
}
