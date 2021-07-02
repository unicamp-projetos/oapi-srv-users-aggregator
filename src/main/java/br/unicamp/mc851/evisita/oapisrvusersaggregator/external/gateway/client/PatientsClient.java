package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.client;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.SavePatientRequest;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.SavePatientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "oapi-srv-patients", url = "${oapi.srv.patients}")
public interface PatientsClient {
    @PostMapping(value = "/patient",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    SavePatientResponse savePatient(SavePatientRequest request);

    @GetMapping(value = "/patient/{medicalRecord}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> getPatientByMedicalRecord(@PathVariable String medicalRecord);
}
