package com.gonzalez.controlador;

import java.util.HashMap;
import java.util.Map;

import com.gonzalez.modelo.Paciente;

public class GestorPacientes {
    private Map<String, Paciente> pacientes;

    public GestorPacientes() {
        this.pacientes = new HashMap<>();
    }

    public void agregarPaciente(Paciente p) {
        pacientes.put(p.getDni(), p);
    }

    public Paciente buscarPorDni(String dni) {
        return pacientes.get(dni);
    }

    public void mostrarPacientes() {
        for (Paciente p : pacientes.values()) {
            System.out.println(p);
        }
    }

    public boolean existePaciente(String dni) {
        return pacientes.containsKey(dni);
    }

    public java.util.Collection<Paciente> getPacientes() {
        return pacientes.values();
    }
}
