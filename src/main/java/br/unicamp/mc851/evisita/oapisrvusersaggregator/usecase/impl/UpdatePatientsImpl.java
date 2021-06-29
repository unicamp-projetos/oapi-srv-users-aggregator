package br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.impl;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter.PatientAdapter;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Patient;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.PatientsGateway;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.dto.PatientDatabaseResponse;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.UpdatePatients;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UpdatePatientsImpl implements UpdatePatients {

    private final PatientsGateway patientsGateway;

    @Override
    public List<Patient> execute(List<PatientDatabaseResponse> patientDatabaseResponses) {
        return patientDatabaseResponses.stream()
                .map(PatientAdapter::convert)
                .filter(p -> patientsGateway.execute(p) != null)
                .collect(Collectors.toList());
    }
}
