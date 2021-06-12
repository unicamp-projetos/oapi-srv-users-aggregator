package br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Patient;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.SavePatientRequest;

public class PatientToSavePatientRequest {
    private PatientToSavePatientRequest() {}

    public static SavePatientRequest convert(Patient patient) {
        return SavePatientRequest.builder()
                .susCardNumber(patient.getSusCardNumber())
                .cpf(patient.getCpf())
                .doctorId(1L)
                .fatherName(patient.getFatherName())
                .medicalRecord(patient.getMedicalRecord())
                .motherName(patient.getMotherName())
                .name(patient.getName())
                .rg(patient.getRg())
                .build();
    }
}
