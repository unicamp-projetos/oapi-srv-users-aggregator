package br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Patient;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.PatientDatabaseResponse;

import java.util.List;

public interface UpdatePatients {
    List<Patient> execute(List<PatientDatabaseResponse> patientDatabaseResponses);
}
