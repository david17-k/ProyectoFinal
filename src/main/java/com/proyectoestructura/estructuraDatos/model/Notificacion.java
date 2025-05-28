package com.proyectoestructura.estructuraDatos.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Notificacion {

    private LocalDateTime fecha;
    private String mensaje;

public Notificacion(){

}

    public Notificacion( String mensaje) {
        this.fecha = fecha;
        this.mensaje = mensaje;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
