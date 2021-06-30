package br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.impl;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.adapter.ReportAdapter;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.CompanionsGateway;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.GetReport;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetReportImpl implements GetReport {

    private final CompanionsGateway gateway;

    @Override
    public ResponseEntity<Object> execute(String cpf) {
        try {
            return ResponseEntity.ok(ReportAdapter.convert(gateway.getCompanion(cpf)));
        } catch (FeignException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
