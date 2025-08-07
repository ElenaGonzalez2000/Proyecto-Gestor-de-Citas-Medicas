package com.gonzalez.controlador;

import java.util.ArrayList;
import java.util.List;

import com.gonzalez.modelo.Medico;

public class GestorMedicos {
    private List<Medico> medicos;

    public GestorMedicos() {
        medicos = new ArrayList<>();
    }

    public void agregarMedico(Medico medico) {
        medicos.add(medico);
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public Medico buscarPorNombre(String nombre) {
        for (Medico m : medicos) {
            if (m.getNombre().equalsIgnoreCase(nombre)) {
                return m;
            }
        }
        return null;
    }

}
