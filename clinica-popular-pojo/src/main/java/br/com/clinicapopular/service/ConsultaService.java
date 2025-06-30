package br.com.clinicapopular.service;

import br.com.clinicapopular.model.Consulta;
import br.com.clinicapopular.model.Paciente;

import java.util.HashMap;
import java.util.Map;

public class ConsultaService {
    private final Map<String, Paciente> pacientes = new HashMap<>();

    public void agendarConsulta(String cpf, String nome, String dataHora) {
        Paciente paciente = pacientes.getOrDefault(cpf, new Paciente(nome, cpf));
        paciente.adicionarConsulta(new Consulta(dataHora));
        pacientes.put(cpf, paciente);
    }

    public Paciente getPaciente(String cpf) {
        return pacientes.get(cpf);
    }
}