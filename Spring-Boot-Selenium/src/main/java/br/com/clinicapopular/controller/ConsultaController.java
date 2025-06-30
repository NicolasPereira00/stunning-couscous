package br.com.clinicapopular.controller;

import br.com.clinicapopular.model.Consulta;
import br.com.clinicapopular.model.Paciente;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ConsultaController {

    private final Map<String, Paciente> pacientes = new HashMap<>();

    @PostMapping("/consultas")
    public String agendarConsulta(@RequestParam String nome,
                                  @RequestParam String cpf,
                                  @RequestParam String dataHora) {
        Paciente paciente = pacientes.getOrDefault(cpf, new Paciente(nome, cpf));
        paciente.adicionarConsulta(new Consulta(dataHora));
        pacientes.put(cpf, paciente);

        return "Consulta agendada para " + paciente.getNome() + " (CPF: " + paciente.getCpf() + ")";
    }
}