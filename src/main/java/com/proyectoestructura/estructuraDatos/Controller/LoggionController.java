package com.proyectoestructura.estructuraDatos.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class LoggionController {
    private final String USUARIO_VALIDO = "q";
    private final String CONTRASENA_VALIDA = "c";


    @GetMapping("/loggin")
    public String mostrarFormularioLogin() {
        return "home/login";
    }

    @PostMapping("/log")
    public String procesarLogin(
            @RequestParam("usuario") String usuario,
            @RequestParam("password") String contrasena) {

        if (USUARIO_VALIDO.equals(usuario) && CONTRASENA_VALIDA.equals(contrasena)) {
            return "redirect:/cuenta";
        }
        return "home/cuenta";
    }
}






