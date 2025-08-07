package com.gonzalez.modelo;

public class Medico implements Agendable {
    private String nombre;
    private String apellido;
    private String especialidad;
    private boolean disponible;

    // constructor sin parametros
    public Medico () {}

    // constructor con parametros
    public Medico(String nombre, String apellido, String especialidad, boolean disponible) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidad = especialidad;
        this.disponible = disponible;
    }
    
    // getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    // metodos
    @Override
    public String ObtenerInfo() {
        return "Nombre y apellido: " + nombre + " " + apellido + ", Especialidad: " + especialidad;
    }

    @Override
    public String toString() {
        return ObtenerInfo() + (disponible ? ", Actualmente disponible" : ", Actualmente no disponible") ;
    }

}

