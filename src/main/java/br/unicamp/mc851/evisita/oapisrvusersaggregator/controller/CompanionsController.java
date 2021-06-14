package br.unicamp.mc851.evisita.oapisrvusersaggregator.controller;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.CompanionRequest;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.SaveCompanion;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "companions/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CompanionsController {

    private final SaveCompanion saveCompanion;

    @PostMapping(value = "/companion", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveCompanion(@RequestBody CompanionRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(saveCompanion.execute(request));
    }

}
