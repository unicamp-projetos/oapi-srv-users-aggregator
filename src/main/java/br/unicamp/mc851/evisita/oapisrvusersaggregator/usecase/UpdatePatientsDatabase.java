package br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Patient;

import java.util.List;

public interface UpdatePatientsDatabase {
    List<Patient> execute();
}
