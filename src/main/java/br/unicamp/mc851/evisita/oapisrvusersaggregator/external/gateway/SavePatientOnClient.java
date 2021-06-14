package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Patient;

public interface SavePatientOnClient {
    Patient execute(Patient patient);
}
