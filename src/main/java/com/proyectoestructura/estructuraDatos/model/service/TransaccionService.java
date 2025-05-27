package com.proyectoestructura.estructuraDatos.model.service;


import com.proyectoestructura.estructuraDatos.model.Deposito;
import com.proyectoestructura.estructuraDatos.model.Monedero;
import com.proyectoestructura.estructuraDatos.model.ProgramarTransferencias;
import com.proyectoestructura.estructuraDatos.model.Retiro;
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

    @Autowired
    RetiroService retiroService;



    @Transactional
    public void programarRetiro(ProgramarTransferencias programarTransferencias) throws Exception {
       programarTransferenciaRepositorio.save(programarTransferencias);

    }


}
