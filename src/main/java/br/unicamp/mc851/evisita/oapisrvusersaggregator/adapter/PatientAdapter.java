package br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Patient;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.PatientDatabaseResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PatientAdapter {

    public static Patient convert(PatientDatabaseResponse response) {
        return Patient.builder()
                .cpf(response.getCpf())
                .rg(response.getRg())
                .name(response.getName())
                .motherName(response.getMotherName())
                .fatherName(response.getFatherName())
                .doctor(response.getDoctor())
                .medicalRecord(response.getMedicalRecord())
                .susCardNumber(response.getSusCardNumber())
                .bed(response.getBed())
                .functionalUnit(response.getFunctionalUnit())
                .room(response.getRoom())
                .build();
    }
}
