package com.proyectoestructura.estructuraDatos.model;

import com.proyectoestructura.estructuraDatos.estructura.Lista;
import org.springframework.stereotype.Controller;



public class Usuario {
    private String nombre;
    private String apellido;
    private String cedula;
    private String idCuenta;




    public Usuario(String apellido, String cedula, String idCuenta, String nombre) {
        this.apellido = apellido;
        this.cedula = cedula;
        this.idCuenta = idCuenta;
        this.nombre = nombre;
    }

    public Usuario(){

    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
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


    @Override
    public String toString() {
        return "Usuario{" +
                "apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", idCuenta='" + idCuenta + '\'' +
                '}';
    }
}
