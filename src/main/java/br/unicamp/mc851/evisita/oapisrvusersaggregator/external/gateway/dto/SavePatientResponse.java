package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SavePatientResponse {
    @NonNull
    private Long medicalRecord;
    private String name;
    @NonNull
    private Long cpf;
    private String rg;
    @NonNull
    private Long doctorId;
    private String functionalUnit;
    private String bed;
    private String room;
}
