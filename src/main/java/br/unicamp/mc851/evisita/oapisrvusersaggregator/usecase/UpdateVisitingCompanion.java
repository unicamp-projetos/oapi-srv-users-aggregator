package br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.CompanionRequest;

public interface UpdateVisitingCompanion {
    Boolean execute(CompanionRequest request);
}
