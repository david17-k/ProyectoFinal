package com.proyectoestructura.estructuraDatos.model.service;


import com.proyectoestructura.estructuraDatos.estructura.ListaCircularSimple;
import com.proyectoestructura.estructuraDatos.model.Monedero;
import com.proyectoestructura.estructuraDatos.model.Notificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotificarService {

    @Autowired
    EmailService emailService;

        public void enviarNotificacion(Monedero monedero, String mensaje) {
            Notificacion notificacion = new Notificacion();
            notificacion.setMensaje(mensaje);
            notificacion.setFecha(LocalDateTime.now());


            ListaCircularSimple lista = monedero.getListaCircularSimple();

            if (lista == null) {
                lista = new ListaCircularSimple(10);
            }

            lista.agregarInicio(notificacion);
            monedero.setListaCircularSimple(lista);

            // Ahora envías el correo
            String correo ="juand.castilloh@uqvirtual.edu.co";
            emailService.enviarCorreo(correo, "Alerta de cuenta", mensaje);
        }
    }



