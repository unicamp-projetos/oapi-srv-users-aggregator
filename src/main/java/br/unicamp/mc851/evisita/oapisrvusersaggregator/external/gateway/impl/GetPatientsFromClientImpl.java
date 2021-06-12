package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.impl;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter.PatientDatabaseResponseToPatient;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Patient;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.GetPatientsFromClient;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.client.HCClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetPatientsFromClientImpl implements GetPatientsFromClient {

    private final HCClient client;

    @Override
    public List<Patient> execute() {
        var patients = client.execute().stream()
                .map(PatientDatabaseResponseToPatient::convert)
                .collect(Collectors.toList());
        log.info("Patients list retrieved successfully from HC client.");
        return patients;
    }
}
