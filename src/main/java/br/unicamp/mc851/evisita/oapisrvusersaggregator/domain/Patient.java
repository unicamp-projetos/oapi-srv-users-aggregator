package br.unicamp.mc851.evisita.oapisrvusersaggregator.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private Long medicalRecord;
    private String name;
    private String motherName;
    private String fatherName;
    private Long cpf;
    private String rg;
    private Long susCardNumber;
    private String doctor;
    private String functionalUnit;
    private String bed;
    private String room;
}
