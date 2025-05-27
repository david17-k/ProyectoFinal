package com.proyectoestructura.estructuraDatos.model.service;


import com.proyectoestructura.estructuraDatos.model.Deposito;
import com.proyectoestructura.estructuraDatos.model.Monedero;
import com.proyectoestructura.estructuraDatos.model.Usuario;
import com.proyectoestructura.estructuraDatos.repositorio.MonederoRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DepositoService {

    @Autowired
    MonederoRepositorio monederoRepositorio;

    public Monedero validarDeposito(Usuario usuario, Deposito deposito, Monedero monedero){
        if(deposito.getDeposito()==0  || monedero==null){
            throw new RuntimeException();
        }
        monedero.getDeposito().agregarPrimera(deposito);
        return monederoRepositorio.save(monedero);
    }

    public List<Monedero> findAll(){
        return monederoRepositorio.findAll();
    }

}
