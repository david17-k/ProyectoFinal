package com.proyectoestructura.estructuraDatos.model;

import com.proyectoestructura.estructuraDatos.estructura.Cola;
import com.proyectoestructura.estructuraDatos.estructura.Lista;
import com.proyectoestructura.estructuraDatos.util.Serializador;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.PrimitiveIterator;

@Setter
@Getter
@Entity
public class Monedero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCuenta;

    @Lob
    private String usuarioListaJson;

    @Lob
    private String transferenciaColaJson;

    @Lob
    private String inicioSeccionJson;

    @Lob
    private String depositoJson;

    @Transient
    private Lista<Usuario> usuarioLista = new Lista<>();



    @Transient
    private Cola<Usuario> inicioSeccion = new Cola<>();

    @Transient
    private Lista<Deposito> deposito = new Lista<>();



    public void serializarTodo() throws Exception {
        this.usuarioListaJson = Serializador.serializar(usuarioLista);
        this.inicioSeccionJson = Serializador.serializar(inicioSeccion);
        this.depositoJson = Serializador.serializar(deposito);

    }

    public void deserializarTodo() throws Exception {
        if (usuarioListaJson != null) this.usuarioLista = Serializador.deserializarListaUsuario(usuarioListaJson);
        if (inicioSeccionJson != null) this.inicioSeccion = Serializador.deserializarColaUsuario(inicioSeccionJson);
        if (depositoJson != null) this.deposito = Serializador.deserializarListaDeposito(depositoJson);
    }
}

