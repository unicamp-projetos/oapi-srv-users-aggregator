package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.CompanionRequest;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.CompanionResponse;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Companion;
import org.springframework.http.ResponseEntity;

public interface CompanionsGateway {

    CompanionResponse saveCompanionOnClient(Companion companion);

    CompanionResponse getCompanion(String cpf);

    ResponseEntity<Object> updateCompanion(Companion companion);
}
