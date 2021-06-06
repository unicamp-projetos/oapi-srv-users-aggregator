package br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.impl;

import br.unicamp.mc851.evisita.oapisrvusersaggregator.external.gateway.UpdatePacientes;
import br.unicamp.mc851.evisita.oapisrvusersaggregator.usecase.UpdatePacientesDatabase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdatePacientesDatabaseImpl implements UpdatePacientesDatabase {
    private final UpdatePacientes updatePacientes;

    @Override
    public void execute() {
        var pacienteDatabaseResponses = updatePacientes.execute();
    }
}
