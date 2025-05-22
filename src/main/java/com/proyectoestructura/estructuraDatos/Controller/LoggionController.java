package com.proyectoestructura.estructuraDatos.Controller;


import com.proyectoestructura.estructuraDatos.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class LoggionController {
   @Autowired
   ModelController modelController;


    @GetMapping("/loggin")
    public String mostrarFormularioLogin() {
        return "home/login";
    }

    @PostMapping("/log")
    public String procesarLogin(
            @RequestParam("usuario") String usuario,
            @RequestParam("password") String contrasena) {

        if (modelController.verificarInicio(usuario,contrasena)) {
            modelController.guardarLog(usuario);
            return "redirect:/cuenta";
        }
        return "home/login";
    }

    @GetMapping ("/crear")
    public String registrarse(Model model){
        model.addAttribute("usuario",new Usuario());
        return "home/crearcuenta" ;
    }

    @PostMapping("/crear")
    public String procesarRegistro(@ModelAttribute("usuario")Usuario usuario){
        return "redirect: /login";
    }


}






