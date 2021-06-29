package br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Companion;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.SaveCompanionRequest;

public class SaveCompanionRequestAdapter {

    private SaveCompanionRequestAdapter() {}

    public static SaveCompanionRequest convert(Companion companion) {
        return SaveCompanionRequest.builder()
                .cpf(companion.getCpf())
                .rg(companion.getRg())
                .name(companion.getName())
                .patientsId(companion.getPatientsId())
                .build();
    }
}
