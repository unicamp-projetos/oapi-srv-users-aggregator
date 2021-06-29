package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.impl;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.HCClientGateway;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.client.HCClient;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.PatientDatabaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HCClientGatewayImpl implements HCClientGateway {

    private final HCClient client;

    @Override
    public List<PatientDatabaseResponse> execute() {
        return client.execute();
    }
}
