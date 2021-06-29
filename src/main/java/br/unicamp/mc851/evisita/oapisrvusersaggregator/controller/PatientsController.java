package br.unicamp.mc851.evisita.oapisrvusersaggregator.controller;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.SyncDatabase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "users-aggregator/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class PatientsController {
    private final SyncDatabase syncDatabase;

    @GetMapping("/update")
    public ResponseEntity<Object> updateDatabase() {
        syncDatabase.execute();
        log.info("Database wad synced successfully.");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
