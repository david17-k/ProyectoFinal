package com.proyectoestructura.estructuraDatos.estructura;

import java.util.ArrayList;
import java.util.List;

public class Cola <T>{


    private Nodo<T>firts;
    private Nodo<T>end;
    private int size;

    public void push(T dato){
        Nodo<T>aux=new Nodo<>(dato);
        if(verificar()) {
            firts = end=aux;
        }else {
            end.setSiguienteNodo(aux);
            end=aux;
        }
        size++;
    }

    public T poll(){
        if(verificar()){
            System.out.println("Vacia");
        }
        T dato= firts.getDato();
        firts=firts.getSiguienteNodo();

        if(firts==null){
            end=null;
        }
        size--;
        return dato;
    }


    public boolean verificar() {
        return firts==null;
    }




    public void invertir(){
        if(!verificar()){
            T dato=poll();
            invertir();
            push(dato);
        }

    }

    public List<T> toList() {
        List<T> elementos = new ArrayList<>();
        Nodo<T> actual = firts; // o como llames al primer nodo
        while (actual != null) {
            elementos.add(actual.getDato());
            actual = actual.getSiguienteNodo();
        }
        return elementos;
    }

    public void ver(){
        Nodo<T>aux=firts;
        while (aux!=null){
            System.out.println("Datos");
            System.out.println(aux.getDato());
            aux=aux.getSiguienteNodo();
        }
    }

}
