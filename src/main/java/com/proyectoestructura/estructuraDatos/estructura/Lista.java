package com.proyectoestructura.estructuraDatos.estructura;

import java.util.Iterator;

public class Lista <T> implements Iterable<T> {

    private Nodo<T>primerNodo;
    private Nodo<T>ultimoNodo;
    private int tamaño;

    public void agregarPrimera(T dato){
        Nodo<T>nuevoNodo=new Nodo<>(dato);
        if(vacio()){
            primerNodo=nuevoNodo;
        }else{
            nuevoNodo.setSiguienteNodo(primerNodo);
            primerNodo=nuevoNodo;
        }
        tamaño++;
    }

    private boolean vacio() {
        return primerNodo == null;
    }

    public void recorrer(){
        if(vacio()){
            System.out.println("No hay nada");
        }else{
            Nodo<T>aux=primerNodo;
            while (aux!= null){
                System.out.println(aux.getDato());
                aux=aux.getSiguienteNodo();
            }
        }
    }

    public void agregarFinal(T dato){
        Nodo<T>nodo=new Nodo<>(dato);
        if(vacio()){
            primerNodo=ultimoNodo=nodo;
        }else {
            ultimoNodo.setSiguienteNodo(nodo);
            ultimoNodo=nodo;
        }
        tamaño++;
    }

    public void obtenerPosicionImpar(){
        if(vacio()){
            System.out.println("No hay nada");
        }else {
            int indice=0;
            Nodo<T>aux=primerNodo;
            while (aux!=null){
                indice++;
                aux=aux.getSiguienteNodo();
                if(indice%2!=0){
                    System.out.println(aux.getDato());
                }
            }


        }
    }

    public void eliminarUltimoNodo(){
        Nodo<T>eliminar=primerNodo;
        Nodo<T>previo=primerNodo.getSiguienteNodo();

        while (previo.getSiguienteNodo()!=null){
            previo=previo.getSiguienteNodo();
            eliminar=eliminar.getSiguienteNodo();
        }
        eliminar.setSiguienteNodo(null);
        tamaño--;
    }

    public Nodo<T> eliminarPar(){ // 8 1 4
        Nodo<T>aux=primerNodo;
        Nodo<T>anterior=null;
        while (aux!=null){
            if(verificar(aux.getDato())) {
                if(anterior==null){
                    primerNodo=aux.getSiguienteNodo();
                }else {
                    anterior.setSiguienteNodo(aux.getSiguienteNodo());
                }
            }else {
                anterior=aux;
            }
            aux=aux.getSiguienteNodo();

        }
        return primerNodo;

    }

    private boolean isEmpti(Nodo<T> aux) {
        if(aux==null){
            return true;
        }else {
            return false;
        }
    }

    private boolean verificar(T dato) {
        int numero=(int)dato;
        if(numero%2==0){
            return true;
        }else {
            return false;
        }
    }

    public void mostrarContenido(){
        Nodo<T>aux=primerNodo;
        while (aux!=null){
            System.out.println(aux.getDato());
            aux=aux.getSiguienteNodo();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new iterador(primerNodo);
    }

    public class iterador implements Iterator<T>{

        Nodo<T>nodo;

        public iterador(Nodo<T> nodo) {
            this.nodo = nodo;
        }

        @Override
        public boolean hasNext() {
            return nodo!=null;
        }

        @Override
        public T next() {
            T dato=nodo.getDato();
            nodo=nodo.getSiguienteNodo();
            return dato;
        }

    }


}
