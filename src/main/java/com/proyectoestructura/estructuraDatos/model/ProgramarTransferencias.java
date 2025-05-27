package com.proyectoestructura.estructuraDatos.model;


import com.proyectoestructura.estructuraDatos.estructura.Cola;
import com.proyectoestructura.estructuraDatos.util.Serializador;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Entity
public class ProgramarTransferencias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Lob
    private String depositoJson;
    @Lob
    private String retiroJson;
    @Lob
    private String transferirJson;

    private LocalDateTime fecha;
    @Transient
    private Cola<Deposito>deposito;
    @Transient
    private Cola<Retiro>retiro=new Cola<>();
    @Transient
    private Cola<Transferir>transferirCola;

    private double monto;
    private String tipo;



    public void serializarTransacciones() throws Exception {
        this.depositoJson= Serializador.serializar(deposito);
        this.retiroJson=Serializador.serializar(retiro);
        this.transferirJson=Serializador.serializar(transferirCola);
    }

    public void deserializarTransaccion() throws Exception {
        if(depositoJson!=null)this.deposito=Serializador.deserializarColaDeposito(depositoJson);
        if(retiroJson!=null)this.retiro=Serializador.deserializarColaRetiro(retiroJson);
    }




}
