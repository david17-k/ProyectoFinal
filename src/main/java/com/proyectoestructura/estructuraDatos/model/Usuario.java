package com.proyectoestructura.estructuraDatos.model;

import com.proyectoestructura.estructuraDatos.estructura.Lista;
import jakarta.persistence.*;
import lombok.ToString;
import org.springframework.stereotype.Controller;

@ToString
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;


    private String nombre;
    private String apellido;
    private String cedula;
    private String idCuenta;
    private String celular;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Monedero monedero;


    public Usuario(String apellido, String cedula, long id, String idCuenta, Monedero monedero, String nombre) {
        this.apellido = apellido;
        this.cedula = cedula;
        this.id = id;
        this.idCuenta = idCuenta;
        this.monedero = monedero;
        this.nombre = nombre;
    }

    public Usuario(String apellido, String cedula, String idCuenta, String nombre) {
        this.apellido = apellido;
        this.cedula = cedula;
        this.idCuenta = idCuenta;
        this.nombre = nombre;
    }

    public Usuario(){

    }

    public Monedero getMonedero() {
        return monedero;
    }

    public void setMonedero(Monedero monedero) {
        this.monedero = monedero;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

}
