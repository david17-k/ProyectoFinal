package com.proyectoestructura.estructuraDatos.Controller;

import com.proyectoestructura.estructuraDatos.model.Deposito;
import com.proyectoestructura.estructuraDatos.model.Monedero;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class DepositoController {

    @Autowired
   private ModelController modelController;
    private ApiController apiController;

   @GetMapping("/deposito")
   public String depositar(Model model){
       return "home/Deposito";
   }

    @PostMapping("/deposito")
    public String depositar(@ModelAttribute("deposito")Deposito deposito, BindingResult bindingResult, HttpSession httpSession){
       if(bindingResult.hasErrors()){
           return "home/Deposito";
       }
        Monedero monedero=(Monedero)httpSession.getAttribute("monedero");
       if(monedero!=null){
           monedero.getDeposito().agregarPrimera(deposito);
           httpSession.setAttribute("monedero",monedero);
       }
        return "redirect:/cuenta";
        }

}
