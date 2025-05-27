package com.proyectoestructura.estructuraDatos.model.service;


import com.proyectoestructura.estructuraDatos.model.Monedero;
import com.proyectoestructura.estructuraDatos.model.Retiro;
import com.proyectoestructura.estructuraDatos.repositorio.MonederoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetiroService {

    @Autowired
    MonederoRepositorio monederoRepositorio;

}
