package br.unicamp.mc851.evisita.oapisrvusersaggregator.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Companion {
    private String name;
    private String cpf;
    private String rg;
    private List<VisitInfo> visitInfo;
}
