package br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.CompanionRequest;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Companion;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.CompanionDatabaseResponse;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.PatientDatabaseResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CompanionAdapter {
    private CompanionAdapter() {}

    public static Companion convert(CompanionDatabaseResponse response) {
        return Companion.builder()
                .cpf(response.getCpf())
                .rg(getRg(response.getRg()))
                .name(response.getName())
                .patientsId(new ArrayList<>())
                .build();
    }

    private static String getRg(String rg) {
        return (rg == null) ? "":rg;
    }

    public static Companion convert(CompanionDatabaseResponse response, Long patientId) {
        return Companion.builder()
                .cpf(response.getCpf())
                .rg(getRg(response.getRg()))
                .name(response.getName())
                .patientsId(Arrays.asList(patientId))
                .build();
    }

    public static Companion convert(CompanionRequest request) {
        return Companion.builder()
                .name(request.getName())
                .cpf(request.getCpf())
                .rg(request.getRg())
                .patientsId(request.getPatientsId())
                .build();
    }

    public static List<Companion> convert(PatientDatabaseResponse response) {
        return response.getCompanions()
                .stream()
                .map(cDR -> CompanionAdapter.convert(cDR, response.getMedicalRecord()))
                .collect(Collectors.toList());
    }
}
