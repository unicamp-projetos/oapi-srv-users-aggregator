package br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.CompanionRequest;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.CompanionResponse;

public interface SaveCompanion {
    CompanionResponse execute(CompanionRequest request);
}
