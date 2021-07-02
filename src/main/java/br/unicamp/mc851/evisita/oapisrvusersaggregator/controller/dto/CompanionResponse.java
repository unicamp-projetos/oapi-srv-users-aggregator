package br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto;

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
public class CompanionResponse {
    private String name;
    private String cpf;
    private List<VisitInfo> visitInfo;
}
