package br.unicamp.mc851.evisita.oapisrvusersaggregator.controller;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.UpdatePatientsDatabase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "pacientes/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class PatientsController {
    private final UpdatePatientsDatabase updatePatientsDatabase;

    @GetMapping("/update")
    public ResponseEntity<Object> updateDatabase() {
        updatePatientsDatabase.execute();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
