package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Patient;

import java.util.List;

public interface GetPatientsFromClient {
    List<Patient> execute();
}
