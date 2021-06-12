package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.impl;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter.PatientToSavePatientRequest;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Patient;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.SavePatient;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.client.OapiSrvPatientsClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SavePatientImpl implements SavePatient {

    private final OapiSrvPatientsClient client;

    @Override
    public Patient execute(Patient patient) {
        try {
            client.execute(PatientToSavePatientRequest.convert(patient));
            log.info("Patient {} registered successfully.", patient.getName());
            return patient;
        } catch (FeignException e) {
            log.info("Patient {} was not registered.", patient.getName());
            return null;
        }
    }
}
