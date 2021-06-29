package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.PatientDatabaseResponse;

import java.util.List;

public interface HCClientGateway {
    List<PatientDatabaseResponse> execute();
}
