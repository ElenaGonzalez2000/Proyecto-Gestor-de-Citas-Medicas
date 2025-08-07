package com.gonzalez.modelo;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Cita {
    private LocalDateTime fechaHora;
    private Paciente paciente;
    private Medico medico;
    private String estado;

    // constructor sin parametros
    public Cita() {};

    // constructor con parametros
    public Cita(LocalDateTime fechaHora, Paciente paciente, Medico medico, String estado) {
        this.fechaHora = fechaHora;
        this.paciente = paciente;
        this.medico = medico;
        this.estado = estado;
    }

    // getters y setters
    public LocalDateTime getFechaHora() {return fechaHora;}
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }

    public Paciente getPaciente() {return paciente;}
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public Medico getMedico() {return medico;}
    public void setMedico(Medico medico) { this.medico = medico; }

    public String getEstado() {return estado;}
    public void setEstado(String estado) { this.estado = estado; }

    // sobreescritura del metodo toString() y formateo de fecha y hora
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        return "Fecha de la cita: " + fechaHora.format(formatter) + " - Medico: " + medico.getNombre() + " " + medico.getApellido() + " - Paciente: " + paciente.getNombre() + " " + paciente.getApellido();
    }
}