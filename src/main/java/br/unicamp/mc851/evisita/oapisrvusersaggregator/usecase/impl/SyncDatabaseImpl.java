package br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.impl;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.GetPatientsFromClient;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.FilterCompanions;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.SyncDatabase;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.UpdateCompanions;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.UpdatePatients;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SyncDatabaseImpl implements SyncDatabase {

    private final FilterCompanions filterCompanions;
    private final UpdatePatients updatePatients;
    private final GetPatientsFromClient getPatientsFromClient;
    private final UpdateCompanions updateCompanions;

    @Override
    public void execute() {
        var databaseResponseList = getPatientsFromClient.execute();
        var medicalRecords = updatePatients.execute(databaseResponseList).stream()
                .map(p -> p.getMedicalRecord())
                .collect(Collectors.toSet());
        updateCompanions.execute(filterCompanions.execute(databaseResponseList, medicalRecords));
    }
}
