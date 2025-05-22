package com.proyectoestructura.estructuraDatos.model;

import com.proyectoestructura.estructuraDatos.estructura.Cola;
import com.proyectoestructura.estructuraDatos.estructura.Lista;

import java.util.PrimitiveIterator;

public class Monedero {

    private Lista<Usuario>usuarioLista=new Lista<>();
    private Cola<Transferencia>transferenciaCola=new Cola<>();
    private Cola<String>inicioSeccion=new Cola<>();

    public Cola<String> getInicioSeccion() {
        return inicioSeccion;
    }

    public void setInicioSeccion(Cola<String> inicioSeccion) {
        this.inicioSeccion = inicioSeccion;
    }

    public Cola<Transferencia> getTransferenciaCola() {
        return transferenciaCola;
    }

    public void setTransferenciaCola(Cola<Transferencia> transferenciaCola) {
        this.transferenciaCola = transferenciaCola;
    }

    public Lista<Usuario> getUsuarioLista() {
        return usuarioLista;
    }

    public void setUsuarioLista(Lista<Usuario> usuarioLista) {
        this.usuarioLista = usuarioLista;
    }
}
