package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.client;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.SaveCompanionRequest;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.SaveCompanionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "oapi-srv-companions", url = "${oapi.srv.companions}")
public interface CompanionsClient {
    @PostMapping(value = "/companion",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    SaveCompanionResponse save(@RequestBody SaveCompanionRequest request);

    @GetMapping(value = "/companion/{cpf}", consumes = MediaType.APPLICATION_JSON_VALUE)
    SaveCompanionResponse retrieve(@PathVariable String cpf);

    @PutMapping(value = "/companion")
    ResponseEntity<Object> updateCompanion(@RequestBody SaveCompanionRequest request);
}
