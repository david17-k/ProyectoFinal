package com.proyectoestructura.estructuraDatos.model;

public class Transaccion {
    private String fecha;
    private String tipo;
    private double monto;
    private String moneda;
    private String descripcion;

    // Constructor, getters, setters...

    public Transaccion(String fecha, String tipo, double monto, String moneda, String descripcion) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.monto = monto;
        this.moneda = moneda;
        this.descripcion = descripcion;
    }

    // Getters...
}

