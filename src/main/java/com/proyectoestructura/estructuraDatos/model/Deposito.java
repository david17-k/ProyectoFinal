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
public class Deposito{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long idCuenta;


    private double deposito;
    public Deposito(){

    }


    public Deposito(double deposito) {
        this.deposito = deposito;
    }

    @Override
    public String toString() {
        return "Deposito{" +
                "deposito=" + deposito +
                ", idCuenta=" + idCuenta +
                '}';
    }
}
