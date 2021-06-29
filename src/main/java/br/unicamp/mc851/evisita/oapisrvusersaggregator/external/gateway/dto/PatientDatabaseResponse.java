package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDatabaseResponse {
    @NonNull
    @JsonProperty("prontuario")
    private Long medicalRecord;
    @NonNull
    @JsonProperty("nome")
    private String name;
    @JsonProperty("nome_mae")
    private String motherName;
    @JsonProperty("nome_pai")
    private String fatherName;
    @NonNull
    private Long cpf;
    private String rg;
    @JsonProperty("nro_cartao_saude")
    private Long susCardNumber;
    @NonNull
    @JsonProperty("medico")
    private String doctor;
    @JsonProperty("unidade_funcional")
    private String functionalUnit;
    @JsonProperty("quarto")
    private String room;
    @JsonProperty("leito")
    private String bed;
    @JsonProperty("acompanhantes")
    private List<CompanionDatabaseResponse> companions;
}
