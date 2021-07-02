package br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.impl;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter.CompanionRequestAdapter;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Patient;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.HCClientGateway;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.FilterCompanions;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.SaveCompanion;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.SavePatientsOnDatabase;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.SyncDatabase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SyncDatabaseImpl implements SyncDatabase {

    private final FilterCompanions filterCompanions;
    private final SavePatientsOnDatabase savePatientsOnDatabase;
    private final HCClientGateway hcClientGateway;
    private final SaveCompanion saveCompanion;

    @Override
    public void execute() {
        var databaseResponseList = hcClientGateway.execute();
        var medicalRecords = savePatientsOnDatabase.execute(databaseResponseList).stream()
                .map(Patient::getMedicalRecord)
                .collect(Collectors.toSet());
        filterCompanions.execute(databaseResponseList, medicalRecords)
                .parallelStream()
                .map(CompanionRequestAdapter::convert)
                .map(saveCompanion::execute);
    }
}
