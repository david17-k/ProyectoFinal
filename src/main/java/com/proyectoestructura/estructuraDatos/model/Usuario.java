package com.proyectoestructura.estructuraDatos.model;

public class Usuario {
    private String nombre;
    private String apellido;
    private String cedula;

    public Usuario(String apellido, String cedula, String nombre) {
        this.apellido = apellido;
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
