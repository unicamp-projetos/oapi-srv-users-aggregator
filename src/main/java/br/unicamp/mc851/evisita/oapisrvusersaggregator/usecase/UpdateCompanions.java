package br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.domain.Companion;

import java.util.List;

public interface UpdateCompanions {
    void execute(List<Companion> companions);
}
