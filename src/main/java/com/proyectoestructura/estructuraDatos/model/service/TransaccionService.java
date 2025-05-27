package com.proyectoestructura.estructuraDatos.model.service;


import com.proyectoestructura.estructuraDatos.model.Deposito;
import com.proyectoestructura.estructuraDatos.model.Monedero;
import com.proyectoestructura.estructuraDatos.repositorio.MonederoRepositorio;
import com.proyectoestructura.estructuraDatos.repositorio.ProgramarTransferenciaRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransaccionService {


    @Autowired
    ProgramarTransferenciaRepositorio programarTransferenciaRepositorio;

    @Autowired
    MonederoRepositorio monederoRepositorio;

    @Autowired
    DepositoService depositoService;

/*
    @Transactional
    public Monedero programarDeposito(Deposito deposito){
        deposito.
        Monedero monedero=this.monederoRepositorio.save(deposito);
    }
    */

}
