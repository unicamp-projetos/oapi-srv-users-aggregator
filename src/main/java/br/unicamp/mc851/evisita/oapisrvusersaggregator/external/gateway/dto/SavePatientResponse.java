package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SavePatientResponse {
    @NonNull
    private String medicalRecord;
    private String name;
    @NonNull
    private String cpf;
    private String rg;
    @NonNull
    private Long doctorId;
    private String functionalUnit;
    private String bed;
    private String room;
}
