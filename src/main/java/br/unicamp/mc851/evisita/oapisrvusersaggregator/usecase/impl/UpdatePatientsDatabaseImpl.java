package br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.impl;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.GetPatientsFromClient;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.UpdatePatientsDatabase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePatientsDatabaseImpl implements UpdatePatientsDatabase {

    private final GetPatientsFromClient getPatientsFromClient;

    @Override
    public void execute() {
        var patients = getPatientsFromClient.execute();
        patients.stream().forEach(p -> System.out.println(p));
        patients.parallelStream().forEach(p -> System.out.println(p));
    }
}
