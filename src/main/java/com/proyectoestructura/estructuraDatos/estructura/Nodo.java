package com.proyectoestructura.estructuraDatos.estructura;

public class Nodo <T>{
    private Nodo<T>siguienteNodo;
    private T dato;

    public Nodo(T dato) {
        this.dato = dato;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(Nodo<T> siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }
}
