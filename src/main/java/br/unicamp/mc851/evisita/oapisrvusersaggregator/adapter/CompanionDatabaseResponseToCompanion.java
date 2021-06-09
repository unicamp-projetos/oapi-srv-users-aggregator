package br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Companion;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.CompanionDatabaseResponse;

import java.util.ArrayList;

public class CompanionDatabaseResponseToCompanion {
    private CompanionDatabaseResponseToCompanion() {}

    public static Companion convert(CompanionDatabaseResponse response) {
        return Companion.builder()
                .cpf(response.getCpf())
                .rg(getRg(response.getRg()))
                .name(response.getNome())
                .idPatients(new ArrayList<>())
                .build();
    }

    private static String getRg(String rg) {
        return (rg == null) ? "":rg;
    }
}