package br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.impl;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.PatientsGateway;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.CheckIfPatientExists;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckIfPatientExistsImpl implements CheckIfPatientExists {

    private final PatientsGateway gateway;

    @Override
    public Boolean execute(String medicalRecord) {
        return gateway.getPatientByMedicalRecord(medicalRecord)
                .getStatusCode()
                .is2xxSuccessful();
    }
}
