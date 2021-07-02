package br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.controller.dto.CompanionRequest;

public interface SwapCompanions {
    Boolean execute(CompanionRequest currentCompanion, CompanionRequest newCompaion);
}
