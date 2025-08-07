package com.gonzalez.modelo;

public class Paciente implements Agendable {
    private String nombre;
    private String apellido;
    private int edad;
    private String dni;
    private String telefono;

    // constructor sin parametros
    public Paciente() {}

    // constructor con parametros
    public Paciente(String nombre, String apellido, int edad, String dni, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
        this.telefono = telefono;
    }

    // getters y setters

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre;}

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido;}

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad;}

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni;}

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }


    // metodos
    @Override
    public String ObtenerInfo() {
        return "Nombre: " + nombre + ", Apellido: " + apellido + ", DNI: " + dni + ", Telefono: " + telefono;
    }

    @Override
    public String toString(){
        return ObtenerInfo();
    }
    
}
