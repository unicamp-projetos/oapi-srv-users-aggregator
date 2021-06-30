package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SavePatientRequest {
    @NonNull
    private String medicalRecord;
    @NonNull
    private String name;
    private String motherName;
    private String fatherName;
    @NonNull
    private String cpf;
    private String rg;
    private String susCardNumber;
    private @NonNull String doctor;
    private String functionalUnit;
    private String bed;
    private String room;
}
