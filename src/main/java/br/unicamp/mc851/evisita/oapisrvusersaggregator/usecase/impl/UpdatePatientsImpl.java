package br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.impl;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter.PatientDatabaseResponseToPatient;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Patient;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.GetPatientsFromClient;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.SavePatientOnClient;
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

    private final SavePatientOnClient savePatientOnClient;

    @Override
    public List<Patient> execute(List<PatientDatabaseResponse> patientDatabaseResponses) {
        return patientDatabaseResponses.stream()
                .map(PatientDatabaseResponseToPatient::convert)
                .filter(p -> savePatientOnClient.execute(p) != null)
                .collect(Collectors.toList());
    }
}
