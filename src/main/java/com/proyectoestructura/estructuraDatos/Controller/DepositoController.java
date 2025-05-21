package com.proyectoestructura.estructuraDatos.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class DepositoController {

   private ModelController modelController;

    @PostMapping("/depositar")
    public void depositar(@RequestParam("depositar") int deposito){
        modelController.depositar(deposito);
        System.out.println("Deposito exitoso");
        }

}
