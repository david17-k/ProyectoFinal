package com.proyectoestructura.estructuraDatos.model;

import com.proyectoestructura.estructuraDatos.estructura.Lista;

import com.proyectoestructura.estructuraDatos.model.service.DepositoService;


import java.util.List;

public class Cuenta {


    private String contraseña;
    private String idUsuario;

    public Cuenta(){

    }


    public Cuenta(String contraseña, String idUsuario) {
        this.contraseña = contraseña;
        this.idUsuario = idUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }


}
