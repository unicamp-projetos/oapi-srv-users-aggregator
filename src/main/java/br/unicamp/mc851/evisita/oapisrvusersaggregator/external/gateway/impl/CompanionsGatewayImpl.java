package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.impl;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter.CompanionResponseAdapter;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter.SaveCompanionRequestAdapter;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.CompanionResponse;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Companion;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.CompanionsGateway;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.client.CompanionsClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CompanionsGatewayImpl implements CompanionsGateway {

    private final CompanionsClient client;

    @Override
    public CompanionResponse saveCompanionOnClient(Companion companion) {
        try {
            return CompanionResponseAdapter.convert(
                    client.save(SaveCompanionRequestAdapter.convert(companion)));
        } catch (FeignException e) {
            log.info("Companion {} was not registered on database.", companion.getName());
            return null;
        }
    }

    @Override
    public CompanionResponse getCompanion(String cpf) {
        return CompanionResponseAdapter.convert(client.retrieve(cpf));
    }

    @Override
    public ResponseEntity<Object> updateCompanion(Companion companion) {
        return client.updateCompanion(SaveCompanionRequestAdapter.convert(companion));
    }
}
