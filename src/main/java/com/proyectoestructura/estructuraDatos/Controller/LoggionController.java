package com.proyectoestructura.estructuraDatos.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoggionController {
    @GetMapping("/login")
    public String mostrarFormulario() {
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String correo,
                                @RequestParam String contrasena,
                                Model model) {

        // Usuario de ejemplo (esto debería venir de base de datos)
        String correoValido = "usuario@ejemplo.com";
        String contrasenaValida = "1234";

        if (correo.equals(correoValido) && contrasena.equals(contrasenaValida)) {
            return "redirect:/bienvenido"; // o a tu panel
        } else {
            model.addAttribute("error", "Correo o contraseña incorrectos");
            return "login";
        }
    }

    @GetMapping("/bienvenido")
    public String bienvenido() {
        return "<h1>Bienvenido al Monedero</h1>"; // temporal
    }
}



