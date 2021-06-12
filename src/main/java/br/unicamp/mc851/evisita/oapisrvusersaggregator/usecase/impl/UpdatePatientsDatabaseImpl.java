package br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.impl;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Patient;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.GetPatientsFromClient;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.SavePatient;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.UpdatePatientsDatabase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UpdatePatientsDatabaseImpl implements UpdatePatientsDatabase {

    private final GetPatientsFromClient getPatientsFromClient;
    private final SavePatient savePatient;

    @Override
    public List<Patient> execute() {
        var patients = getPatientsFromClient.execute();
        return patients.stream()
                .filter(p -> savePatient.execute(p) != null)
                .collect(Collectors.toList());
    }
}
