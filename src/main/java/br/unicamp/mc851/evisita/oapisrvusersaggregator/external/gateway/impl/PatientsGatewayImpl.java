package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.impl;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter.SavePatientRequestAdapter;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Patient;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.PatientsGateway;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.client.PatientsClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PatientsGatewayImpl implements PatientsGateway {

    private final PatientsClient client;

    @Override
    public Patient savePatient(Patient patient) {
        try {
            client.savePatient(SavePatientRequestAdapter.convert(patient));
            return patient;
        } catch (FeignException e) {
            log.info("Patient {} was not registered.", patient.getName());
            return null;
        }
    }

    @Override
    public ResponseEntity<Object> getPatientByMedicalRecord(String medicalRecord) {
        return client.getPatientByMedicalRecord(medicalRecord);
    }
}
