package com.gonzalez.controlador;

import java.util.ArrayList;
import java.util.List;

import com.gonzalez.modelo.Cita;

public class GestorCitas {
    private List<Cita> citas;

    public GestorCitas() {
        this.citas = new ArrayList<>();
    }

    // metodos para agregar cita
    public void agregarCita(Cita cita) {
        citas.add(cita);
    }

    // metodo para eliminar una cita
    public void cancelarCita(Cita cita) {
        if (cita != null) {
            cita.setEstado("Cancelada");
        }
    }

    // metodo recursivo: cuenta cuantas citas tienen el estado "Activa"
    public int contarCitasActivasRecursiva(int index) {
        if (index >= citas.size())
            return 0;
        int suma = citas.get(index).getEstado().equalsIgnoreCase("Activa") ? 1 : 0;
        return suma + contarCitasActivasRecursiva(index + 1);
    }

    // version iterativa de metodo recursivo
    public int contarCitasActivasIterativo() {
        int contador = 0;
        for (Cita c : citas) {
            if (c.getEstado().equalsIgnoreCase("Activa")) {
                contador++;
            }
        }
        return contador;
    }

    // metodo para mostrar citas
    public void mostrarCitas() {
        for (Cita c : citas) {
            System.out.println(c);
        }
    }

    public List<Cita> getCitas() {
        return citas;
    }

}