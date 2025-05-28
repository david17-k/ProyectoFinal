package com.proyectoestructura.estructuraDatos.model;

import com.proyectoestructura.estructuraDatos.estructura.Arbol;
import com.proyectoestructura.estructuraDatos.estructura.Cola;
import com.proyectoestructura.estructuraDatos.estructura.Lista;
import com.proyectoestructura.estructuraDatos.estructura.ListaCircularSimple;
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
    private long id;

    @Lob
    private String usuarioListaJson;

    @Lob
    private String transferenciaColaJson;

    @Lob
    private String inicioSeccionJson;

    @Lob
    private String depositoJson;

    @Lob
    private String retirarJson;

    @Lob
    private String historialJson;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    private double saldo=0;

    @Column
    private int puntos=0;

    private Rangos rangos;






    @Transient
    private Cola<Usuario> inicioSeccion = new Cola<>();

    @Transient
    private Lista<Deposito> deposito = new Lista<>();

    @Transient
    private Lista<Transferir>tranferir=new Lista<>();

    @Transient
    private Lista<Retiro>retiros=new Lista<>();

    @Transient
    private Lista<Transaccion>historial=new Lista<>();

    @Transient
    private Arbol punto=new Arbol();


@Transient
private ListaCircularSimple listaCircularSimple=new ListaCircularSimple(10);



    public void setPuntos(int puntos) {
        this.puntos = puntos;
        this.rangos = Rangos.obtenerRango(puntos);
    }



    public void serializarTodo() throws Exception {
        this.retirarJson=Serializador.serializar(retiros);
        this.depositoJson = Serializador.serializar(deposito);
        this.historialJson=Serializador.serializar(historial);


    }

    public void deserializarTodo() throws Exception {
        if (depositoJson != null) this.deposito = Serializador.deserializarListaDeposito(depositoJson);
        if(retirarJson!=null)this.retiros=Serializador.deserealizarListaRetiro(retirarJson);
        if(historialJson!=null)this.historial=Serializador.deserealizarListaHistorial(historialJson);
    }

}

