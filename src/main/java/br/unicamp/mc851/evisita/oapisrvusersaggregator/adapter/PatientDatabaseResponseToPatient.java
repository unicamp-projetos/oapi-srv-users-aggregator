package br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Patient;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.PatientDatabaseResponse;

public class PatientDatabaseResponseToPatient {
    private PatientDatabaseResponseToPatient() {}

    public static Patient convert(PatientDatabaseResponse response) {
        return Patient.builder()
                .cpf(response.getCpf())
                .rg(response.getRg())
                .name(response.getNome())
                .motherName(response.getNome_mae())
                .fatherName(response.getNome_pai())
                .doctor(response.getMedico())
                .medicalRecord(response.getProntuario())
                .susCardNumber(response.getNro_cartao_saude())
                .build();
    }
}
