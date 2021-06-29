package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.client;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.PatientDatabaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "hc-client", url = "${patients.mock.url}")
public interface HCClient {
    @GetMapping(value = "/patients", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<PatientDatabaseResponse> execute();
}
