package com.proyectoestructura.estructuraDatos.Controller;

import com.proyectoestructura.estructuraDatos.model.Deposito;
import com.proyectoestructura.estructuraDatos.model.Monedero;
import com.proyectoestructura.estructuraDatos.model.Transaccion;
import com.proyectoestructura.estructuraDatos.model.Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@Controller
public class DepositoController {

    @Autowired
   private ModelController modelController;
    @Autowired
    private ApiController apiController;

   @GetMapping("/deposito")
   public String depositar(Model model){
       return "home/Deposito";
   }

    @PostMapping("/deposito")
    public String depositar(@ModelAttribute("Deposito")Deposito deposito, BindingResult bindingResult, HttpSession httpSession){
       if(bindingResult.hasErrors()){
           return "home/Deposito";
       }
        Monedero monedero=(Monedero)httpSession.getAttribute("monedero");
        Usuario usuario=(Usuario) httpSession.getAttribute("usuario");
       if(monedero!=null){
           monedero.getDeposito().agregarPrimera(deposito);
           apiController.guardarDeposito(deposito);
           httpSession.setAttribute("monedero",monedero);
           Transaccion transaccion=new Transaccion();
           transaccion.setTipo("Deposito");
           transaccion.setMonto(deposito.getDeposito());
           transaccion.setLocalDate(LocalDate.now());
           transaccion.setUsuario(usuario);

           apiController.guardarHistorial(transaccion);
       }
        return "redirect:/cuenta";
        }

}
