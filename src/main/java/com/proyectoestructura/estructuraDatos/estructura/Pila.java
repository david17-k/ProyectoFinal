package com.proyectoestructura.estructuraDatos.estructura;

public class Pila <T>{

    private Nodo<T>cima;
    private int tamaño;

    public void apilar(T dato){
        Nodo<T>aux=new Nodo<>(dato);
        if(cima==null){
            cima=aux;
        }else{
            aux.setSiguienteNodo(cima);
            cima=aux;
        }
        tamaño++;
    }

    public T desapilar() {
        if (cima == null) {
            System.out.println("NO hay nada");
        }
        T dato = cima.getDato();
        cima = cima.getSiguienteNodo();
        tamaño--;
        return dato;
    }

    public void imprimir(){
        Nodo<T>aux=cima;
        while (aux!=null){
            System.out.println(aux.getDato());
            aux=aux.getSiguienteNodo();
        }
    }

    public boolean isEmpty() {
        return cima==null;
    }
}
