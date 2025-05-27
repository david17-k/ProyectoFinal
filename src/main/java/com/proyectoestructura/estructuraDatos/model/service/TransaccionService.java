package com.proyectoestructura.estructuraDatos.model.service;


import com.proyectoestructura.estructuraDatos.estructura.Cola;
import com.proyectoestructura.estructuraDatos.model.Deposito;
import com.proyectoestructura.estructuraDatos.model.Monedero;
import com.proyectoestructura.estructuraDatos.model.ProgramarTransferencias;
import com.proyectoestructura.estructuraDatos.model.Retiro;
import com.proyectoestructura.estructuraDatos.repositorio.MonederoRepositorio;
import com.proyectoestructura.estructuraDatos.repositorio.ProgramarTransferenciaRepositorio;
import jakarta.persistence.Version;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@Component
public class TransaccionService {



    @Autowired
    ProgramarTransferenciaRepositorio programarTransferenciaRepositorio;

    @Autowired
    MonederoRepositorio monederoRepositorio;

    @Autowired
    DepositoService depositoService;

    @Autowired
    RetiroService retiroService;


    @Scheduled(cron = "0 * * * * MON-SUN")
    @Transactional
    public void programarRetiro() throws Exception {
        List<ProgramarTransferencias> pr=programarTransferenciaRepositorio.findAll();
       for(ProgramarTransferencias p:pr){
           try {
               if(p.getFecha().isBefore(java.time.LocalDateTime.now())){
                   p.deserializarTransaccion();
                   Cola<Retiro>retiroCola=p.getRetiro();
                   Monedero monedero=p.getUsuario().getMonedero();
                   if(p.getRetiro()!=null && !p.getRetiro().verificar()){
                       System.out.println("Realizando retiro");
                       Retiro retiro= retiroCola.poll();
                       p.serializarTransacciones();
                       retiroService.realizarRetiro(retiro, monedero.getId());
                       ProgramarTransferencias actualizado = programarTransferenciaRepositorio.findById(p.getId())
                               .orElseThrow(() -> new IllegalStateException("No existe programación"));
                       actualizado.setRetiro(p.getRetiro());
                       actualizado.serializarTransacciones();
                       programarTransferenciaRepositorio.save(actualizado);
                       System.out.println("Retiro realizado");
                   }
               }
           } catch (Exception e) {
               System.err.println("Error procesando retiro programado ID " + p.getId() + ": " + e.getMessage());
               e.printStackTrace();
           }
       }
    }

    @Scheduled(cron = "0 * * * * MON-SUN")
    public void deposito(){

    }

}
