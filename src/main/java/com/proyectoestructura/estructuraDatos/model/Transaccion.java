package com.proyectoestructura.estructuraDatos.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
@Entity
public class Transaccion {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;



    private LocalTime fecha;
    private String tipo;
    private double monto;
    private String moneda;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    // Constructor, getters, setters...

    public Transaccion(LocalTime fecha, String tipo, double monto, String moneda, String descripcion) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.monto = monto;
        this.moneda = moneda;
        this.descripcion = descripcion;
    }
    public Transaccion(){

    }

}

