package com.proyectoestructura.estructuraDatos.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Transferir {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double monto;
    private String descripcion;

}
