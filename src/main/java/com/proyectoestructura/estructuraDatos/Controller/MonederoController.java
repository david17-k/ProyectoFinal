package com.proyectoestructura.estructuraDatos.Controller;


import com.proyectoestructura.estructuraDatos.model.Deposito;
import com.proyectoestructura.estructuraDatos.model.Monedero;
import com.proyectoestructura.estructuraDatos.model.Transaccion;
import com.proyectoestructura.estructuraDatos.model.Usuario;
import com.proyectoestructura.estructuraDatos.repositorio.UsuarioRepositorio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MonederoController {

    @Autowired
    ModelController modelController;
    @Autowired
    ApiController apiController;

    @GetMapping("/cuenta")
    public String bienvenida(Model model, HttpSession httpSession){
      Usuario usuario=(Usuario) httpSession.getAttribute("usuario");
        model.addAttribute("nombre",usuario.getNombre());
        Monedero monedero=(Monedero) httpSession.getAttribute("monedero");
            double saldo=0;
           for(Deposito c:monedero.getDeposito()) {
               saldo += c.getDeposito();
               model.addAttribute("saldo", "$" +saldo);
           }
        return "home/cuenta";
    }

    @GetMapping("/depositar")
    public String depositar(Model model,HttpSession httpSession){
        Deposito deposito1=(Deposito)httpSession.getAttribute("deposito");
        System.out.println(deposito1.toString()+"L");
        model.addAttribute("saldo",deposito1.getDeposito());
        return "home/Deposito";
    }

    @PostMapping("/depositar")
    public String deposito(@ModelAttribute("deposito")Deposito deposito,HttpSession httpSession){
       httpSession.setAttribute("deposito",deposito);
        return "home/Deposito";
    }


    @GetMapping("/historial")
    public String verHistorial(HttpSession httpSession,Model model){
        System.out.println("Historial");
        List<Transaccion> historial=apiController.obtenerHistorial();
        model.addAttribute("historial",historial);
        return "home/prueba";
    }

}
