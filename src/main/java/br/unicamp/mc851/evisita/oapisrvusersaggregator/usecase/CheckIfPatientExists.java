package br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Patient;

public interface CheckIfPatientExists {
    Boolean execute(String medicalRecord);
}
