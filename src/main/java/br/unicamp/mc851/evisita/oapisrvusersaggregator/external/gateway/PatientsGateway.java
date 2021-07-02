package br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Patient;
import org.springframework.http.ResponseEntity;

public interface PatientsGateway {

    Patient savePatient(Patient patient);

    ResponseEntity<Object> getPatientByMedicalRecord(String medicalRecord);
}
