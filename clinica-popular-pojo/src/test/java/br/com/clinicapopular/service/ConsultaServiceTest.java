package br.com.clinicapopular.service;

import br.com.clinicapopular.model.Paciente;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConsultaServiceTest {

    @Test
    public void deveCriarPacienteComSucesso() {
        ConsultaService service = new ConsultaService();
        service.agendarConsulta("12345678900", "Maria", "2025-06-30 14:00");

        Paciente paciente = service.getPaciente("12345678900");

        assertNotNull(paciente);
        assertEquals("Maria", paciente.getNome());
    }

    @Test
    public void deveAdicionarConsultaAoPaciente() {
        ConsultaService service = new ConsultaService();
        service.agendarConsulta("12345678900", "João", "2025-07-01 10:00");

        Paciente paciente = service.getPaciente("12345678900");

        assertEquals(1, paciente.getConsultas().size());
        assertEquals("2025-07-01 10:00", paciente.getConsultas().get(0).getDataHora());
    }
}