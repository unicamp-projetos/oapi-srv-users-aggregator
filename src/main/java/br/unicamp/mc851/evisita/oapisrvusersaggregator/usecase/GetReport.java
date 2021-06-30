package br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase;

import org.springframework.http.ResponseEntity;

public interface GetReport {
    ResponseEntity<Object> execute(String cpf);
}
