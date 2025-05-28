package com.proyectoestructura.estructuraDatos.estructura;

import com.proyectoestructura.estructuraDatos.model.Notificacion;

import java.util.ArrayList;
import java.util.List;

public class ListaCircularSimple {

        private NodoNotificacion primerNodo;
        private NodoNotificacion ultimoNodo;
        private int tamaño;
        private final int capacidad;

        public ListaCircularSimple(int capacidad) {
            this.primerNodo = null;
            this.ultimoNodo = null;
            this.tamaño = 0;
            this.capacidad = capacidad;
        }

        public void agregarInicio(Notificacion notificacion) {
            NodoNotificacion nuevoNodo = new NodoNotificacion(notificacion);

            if (estaVacia()) {
                primerNodo = nuevoNodo;
                ultimoNodo = nuevoNodo;
                nuevoNodo.setSiguienteNodo(nuevoNodo);
            } else {
                nuevoNodo.setSiguienteNodo(primerNodo);
                ultimoNodo.setSiguienteNodo(nuevoNodo);
                primerNodo = nuevoNodo;
            }

            if (tamaño == capacidad) {
                eliminarUltimo();
            } else {
                tamaño++;
            }
        }

        private void eliminarUltimo() {
            if (estaVacia()) return;

            NodoNotificacion actual = primerNodo;
            while (actual.getSiguienteNodo() != ultimoNodo) {
                actual = actual.getSiguienteNodo();
            }

            actual.setSiguienteNodo(primerNodo);
            ultimoNodo = actual;
        }

        private boolean estaVacia() {
            return primerNodo == null;
        }

        public List<Notificacion> obtenerNotificaciones() {
            List<Notificacion> lista = new ArrayList<>();
            if (estaVacia()) return lista;

            NodoNotificacion actual = primerNodo;
            do {
                lista.add(actual.getNotificacion());
                actual = actual.getSiguienteNodo();
            } while (actual != primerNodo);

            return lista;
        }
    }



