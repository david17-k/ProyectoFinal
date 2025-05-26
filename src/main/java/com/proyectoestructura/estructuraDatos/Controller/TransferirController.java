package com.proyectoestructura.estructuraDatos.Controller;


import com.proyectoestructura.estructuraDatos.model.Transferir;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TransferirController {
    @Autowired
    ModelController modelController;

    @Autowired
    ApiController apiController;


    @PostMapping("tranferir")
    public String transferir(@ModelAttribute("transferir")Transferir transferir, BindingResult bindingResult, HttpSession httpSession){
        return "home/Envio";

    }
}
