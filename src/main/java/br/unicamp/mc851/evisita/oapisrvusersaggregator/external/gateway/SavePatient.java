package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Patient;

public interface SavePatient {
    Patient execute(Patient patient);
}
