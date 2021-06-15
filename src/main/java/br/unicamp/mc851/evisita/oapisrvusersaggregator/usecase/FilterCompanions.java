package br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Companion;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.PatientDatabaseResponse;

import java.util.List;
import java.util.Set;

public interface FilterCompanions {
    List<Companion> execute(List<PatientDatabaseResponse> patientDatabaseResponses, Set<Long> patientsId);
}
