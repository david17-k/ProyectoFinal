package com.proyectoestructura.estructuraDatos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Retiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double monto;
    private String idCuenta;
    private String descripcion;



}
