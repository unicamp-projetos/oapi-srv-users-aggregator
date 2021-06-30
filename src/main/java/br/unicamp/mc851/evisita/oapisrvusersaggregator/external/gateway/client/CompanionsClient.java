package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.client;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.SaveCompanionRequest;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.SaveCompanionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "oapi-srv-companions", url = "${oapi.srv.companions}")
public interface CompanionsClient {
    @PostMapping(value = "/companion",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    SaveCompanionResponse save(@RequestBody SaveCompanionRequest request);

    @GetMapping(value = "/companion", consumes = MediaType.APPLICATION_JSON_VALUE)
    SaveCompanionResponse retrieve(@RequestParam String cpf);
}
