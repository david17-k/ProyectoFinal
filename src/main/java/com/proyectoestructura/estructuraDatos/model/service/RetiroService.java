package com.proyectoestructura.estructuraDatos.model.service;


import com.proyectoestructura.estructuraDatos.model.Monedero;
import com.proyectoestructura.estructuraDatos.model.ProgramarTransferencias;
import com.proyectoestructura.estructuraDatos.model.Retiro;
import com.proyectoestructura.estructuraDatos.repositorio.MonederoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RetiroService {

    @Autowired
    MonederoRepositorio monederoRepositorio;


    public void realizarRetiro(Retiro retiro,Long id){
       List<Monedero>monedero=monederoRepositorio.findAll();
       for (Monedero m:monedero) {
           if (id.equals(m.getId())) {
               if(m.getSaldo() < retiro.getMonto()){
                   monederoRepositorio.save(m);
               }
                   double descontar= m.getSaldo()- retiro.getMonto();
                   m.setSaldo(descontar);
                   monederoRepositorio.save(m);
                   }
           }
               }
}
