package com.proyectoestructura.estructuraDatos.Controller;

import com.proyectoestructura.estructuraDatos.model.Monedero;
import com.proyectoestructura.estructuraDatos.model.Transaccion;
import com.proyectoestructura.estructuraDatos.model.Usuario;
import com.proyectoestructura.estructuraDatos.repositorio.MonederoRepositorio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.util.List;

@RestController
public class HistorialController {

    @Autowired
    MonederoRepositorio monederoRepositorio;

    @Autowired
    ApiController apiController;


    @PostMapping("/consultarHistorial")
    public String historial(Model model, HttpSession session){


        return "Hola";
    }


}
