package br.unicamp.mc851.evisita.oapisrvusersaggregator.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
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
    private String doctor;
}
