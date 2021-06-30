package br.unicamp.mc851.evisita.oapisrvusersaggregator.controller;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.CompanionRequest;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.GetReport;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.SaveCompanion;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "users-aggregator/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class CompanionsController {

    private final SaveCompanion saveCompanion;
    private final GetReport getReport;

    @PostMapping(value = "/companion", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Save a new companion in database given a medical record of a valid patient")
    @ApiResponse(code = 201, message = "Companion saved successfully")
    public ResponseEntity<Object> saveCompanion(@RequestBody CompanionRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(saveCompanion.execute(request));
    }

    @GetMapping(value = "/companion")
    @ApiOperation("Get report from given Companion identification")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Report generated successfully"),
            @ApiResponse(code = 400, message = "Report could not be generated")
    })
    public ResponseEntity<Object> getReport(@RequestParam String cpf) {
        return getReport.execute(cpf);
    }

}
