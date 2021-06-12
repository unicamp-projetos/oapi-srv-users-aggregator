package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.client;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.PatientDatabaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "patients", url = "http://localhost:8090/pacientes")
public interface HCClient {
    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    List<PatientDatabaseResponse> execute();
}
