package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SavePatientRequest {
    @NonNull
    private Long medicalRecord;
    @NonNull
    private String name;
    private String motherName;
    private String fatherName;
    @NonNull
    private Long cpf;
    private String rg;
    private Long susCardNumber;
    @NonNull
    private Long doctorId;
}
