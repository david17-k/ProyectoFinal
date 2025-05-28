package com.proyectoestructura.estructuraDatos.estructura;

public class ListaCircularSimple <T>{

    private Nodo<T>primerNodo;
    private Nodo<T>ultimoNodo;
    private int tamaño;


    public ListaCircularSimple() {
        primerNodo=null;
        ultimoNodo=null;
        this.tamaño = 0;
    }

    public void agregarInicio(T valorNodo) {
        Nodo<T> nuevoNodo = new Nodo<>(valorNodo);

        if(estaVacia())
        {
            ultimoNodo = nuevoNodo;
            nuevoNodo.setSiguienteNodo(ultimoNodo);
        }
        else
        {
            nuevoNodo.setSiguienteNodo(ultimoNodo.getSiguienteNodo());
            ultimoNodo.setSiguienteNodo(nuevoNodo);
        }
        tamaño++;
    }

    private boolean estaVacia() {
        return primerNodo==null && ultimoNodo==null;
    }

    public boolean buscar(T dato) {
        if (ultimoNodo == null) {  // Si la lista está vacía
            return false;
        }

        Nodo<T> actual = ultimoNodo.getSiguienteNodo();  //
        do {
            if (actual.getDato() == dato) {
                return true;
            }
            actual = actual.getSiguienteNodo();
        } while (actual != ultimoNodo.getSiguienteNodo());

        return false;
    }

    public void imprimir() {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo<T> actual = ultimoNodo.getSiguienteNodo();
        do {
            System.out.print(actual.getDato() + " ");
            actual = actual.getSiguienteNodo();  //
        } while (actual != ultimoNodo.getSiguienteNodo());

        System.out.println();
    }


}

