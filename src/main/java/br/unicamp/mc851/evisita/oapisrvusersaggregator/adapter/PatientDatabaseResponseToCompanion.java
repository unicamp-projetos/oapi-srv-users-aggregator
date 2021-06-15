package br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Companion;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.CompanionDatabaseResponse;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.PatientDatabaseResponse;

import java.util.List;
import java.util.stream.Collectors;

public class PatientDatabaseResponseToCompanion {

    private PatientDatabaseResponseToCompanion() {}

    public static List<Companion> convert(PatientDatabaseResponse response) {
        return response.getAcompanhantes()
                .stream()
                .map(cDR -> CompanionDatabaseResponseToCompanion.convert(cDR, response.getProntuario()))
                .collect(Collectors.toList());
    }
}
