package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.client;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.SaveCompanionRequest;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.SaveCompanionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "oapi-srv-companions", url = "${oapi.srv.companions}/companion")
public interface OapiSrvCompanionsClient {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public SaveCompanionResponse execute(SaveCompanionRequest request);
}
