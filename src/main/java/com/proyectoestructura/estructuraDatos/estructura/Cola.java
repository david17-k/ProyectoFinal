package com.proyectoestructura.estructuraDatos.estructura;

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


    private boolean verificar() {
        return firts==null;
    }




    public void invertir(){
        if(!verificar()){
            T dato=poll();
            invertir();
            push(dato);
        }

    }

    public void ver(){
        Nodo<T>aux=firts;
        while (aux!=null){
            System.out.println(aux.getDato());
            aux=aux.getSiguienteNodo();
        }
    }

}
