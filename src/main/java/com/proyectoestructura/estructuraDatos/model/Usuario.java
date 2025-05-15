package com.proyectoestructura.estructuraDatos.model;

import com.proyectoestructura.estructuraDatos.estructura.Lista;

public class Usuario {
    private String nombre;
    private String apellido;
    private String cedula;

    private Lista<Cuenta>cuentaUsuario=new Lista<>();


    public Usuario(String apellido, String cedula, String nombre) {
        this.apellido = apellido;
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public Lista<Cuenta> getCuentaUsuario() {
        return cuentaUsuario;
    }

    public void setCuentaUsuario(Lista<Cuenta> cuentaUsuario) {
        this.cuentaUsuario = cuentaUsuario;
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
