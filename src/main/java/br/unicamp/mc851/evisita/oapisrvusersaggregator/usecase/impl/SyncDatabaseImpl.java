package br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.impl;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Patient;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.HCClientGateway;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.FilterCompanions;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.SyncDatabase;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.UpdateCompanions;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.UpdatePatients;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SyncDatabaseImpl implements SyncDatabase {

    private final FilterCompanions filterCompanions;
    private final UpdatePatients updatePatients;
    private final HCClientGateway hcClientGateway;
    private final UpdateCompanions updateCompanions;

    @Override
    public void execute() {
        var databaseResponseList = hcClientGateway.execute();
        var medicalRecords = updatePatients.execute(databaseResponseList).stream()
                .map(Patient::getMedicalRecord)
                .collect(Collectors.toSet());
        updateCompanions.execute(filterCompanions.execute(databaseResponseList, medicalRecords));
    }
}
