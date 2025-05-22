package com.proyectoestructura.estructuraDatos.Controller;


import com.proyectoestructura.estructuraDatos.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MonederoController {

    @Autowired
    ModelController modelController;

    @GetMapping("/cuenta")
    public String bienvenida(Model model){
        String usuario=modelController.cuentaUsuario();
        model.addAttribute("title",usuario);
        return "home/cuenta";
    }



}
