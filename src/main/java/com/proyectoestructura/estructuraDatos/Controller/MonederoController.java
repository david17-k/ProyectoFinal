package com.proyectoestructura.estructuraDatos.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MonederoController {

    @GetMapping("/cuentas")
    public String bienvenida(Model model){
        model.addAttribute("title","perra");
        return "home/cuenta";
    }



}
