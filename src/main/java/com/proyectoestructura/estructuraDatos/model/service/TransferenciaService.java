package com.proyectoestructura.estructuraDatos.model.service;


import com.proyectoestructura.estructuraDatos.model.Monedero;
import com.proyectoestructura.estructuraDatos.model.Transaccion;
import com.proyectoestructura.estructuraDatos.model.Transferir;
import com.proyectoestructura.estructuraDatos.model.Usuario;
import com.proyectoestructura.estructuraDatos.repositorio.MonederoRepositorio;
import com.proyectoestructura.estructuraDatos.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferenciaService {
    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    @Autowired
    MonederoRepositorio monederoRepositorio;



    public void realizarTransferencia(Transferir transferir,Long id){
        List<Usuario>list=usuarioRepositorio.findAll();
        Monedero monederos=monederoRepositorio.findByUsuarioId(id).orElseThrow(()->new IllegalStateException("No exite monedero"));
        if(monederos.getSaldo()< transferir.getMonto()){
            System.out.println("Saldo insuficiente");
        }else {
            double calcular=0;
            for (Usuario u : list) {
                if (transferir.getIdUsuario().equals(u.getIdCuenta())) {
                  double aunmentar = transferir.getMonto() +u.getMonedero().getSaldo();
                   u.getMonedero().setSaldo(aunmentar);
                   usuarioRepositorio.save(u);
                   calcular=monederos.getSaldo()-transferir.getMonto();
                   monederos.setSaldo(calcular);
                   monederoRepositorio.save(monederos);
                }
            }
        }

    }
}
