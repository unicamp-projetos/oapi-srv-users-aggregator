package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.client;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.SavePatientRequest;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.SavePatientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "oapi-srv-patients", url = "http://localhost:8080/patients/v1/patient")
public interface OapiSrvPatientsClient {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    SavePatientResponse execute(SavePatientRequest request);
}
