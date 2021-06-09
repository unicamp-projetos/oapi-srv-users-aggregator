package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.client;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.PatientDatabaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "patients", url = "http://localhost:8090/pacientes")
public interface HCClient {
    @RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    List<PatientDatabaseResponse> execute();
}
