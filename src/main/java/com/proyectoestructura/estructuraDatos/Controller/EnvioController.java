package com.proyectoestructura.estructuraDatos.Controller;


import com.proyectoestructura.estructuraDatos.model.Transferir;
import com.proyectoestructura.estructuraDatos.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EnvioController {

    @Autowired
    private ApiController apiController;

    @GetMapping("/enviar")
    public String enviar(){
        return "home/Envio";
    }

    @PostMapping("/enviar")
    public String enviar(@ModelAttribute("Transferir") Transferir transferir, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "home/Envio";
        }
        List<Usuario>usuario=apiController.obtenerUsuario();
        for(Usuario c:usuario){
           if(transferir.getIdUsuario().equals(c.getIdCuenta())){
               c.getMonedero().setSaldo(transferir.getMonto());
           }
        }

        return "redirect:/cuenta";

    }
}
