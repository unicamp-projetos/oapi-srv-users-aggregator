package br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.CompanionRequest;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Companion;

public class CompanionRequestToCompanion {

    private CompanionRequestToCompanion() {}

    public static Companion convert(CompanionRequest request) {
        return Companion.builder()
                .name(request.getName())
                .cpf(request.getCpf())
                .rg(request.getRg())
                .patientsId(request.getPatientsId())
                .build();
    }
}
