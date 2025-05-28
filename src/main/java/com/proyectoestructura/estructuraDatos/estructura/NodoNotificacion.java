package com.proyectoestructura.estructuraDatos.estructura;

import com.proyectoestructura.estructuraDatos.model.Notificacion;

public class NodoNotificacion {

        private Notificacion notificacion;
        private NodoNotificacion siguiente;

        public NodoNotificacion(Notificacion notificacion) {
            this.notificacion = notificacion;
            this.siguiente = null;
        }

    public void setNotificacion(Notificacion notificacion) {
        this.notificacion = notificacion;
    }

    public NodoNotificacion getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoNotificacion siguiente) {
        this.siguiente = siguiente;
    }

    public Notificacion getNotificacion() {
            return notificacion;
        }

        public NodoNotificacion getSiguienteNodo() {
            return siguiente;
        }

        public void setSiguienteNodo(NodoNotificacion siguiente) {
            this.siguiente = siguiente;
        }
}
