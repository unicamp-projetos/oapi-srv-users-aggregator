package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.VisitInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaveCompanionResponse {
    private List<VisitInfo> visitInfo;
    private String name;
    private String cpf;
}
