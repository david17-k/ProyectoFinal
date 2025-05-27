package com.proyectoestructura.estructuraDatos.Controller;


import com.proyectoestructura.estructuraDatos.model.*;
import com.proyectoestructura.estructuraDatos.repositorio.MonederoRepositorio;
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
    @Autowired
    MonederoRepositorio monederoRepositorio;

    @GetMapping("/cuenta")
    public String bienvenida(Model model, HttpSession httpSession){
      Usuario usuario=(Usuario) httpSession.getAttribute("usuario");
        model.addAttribute("nombre",usuario.getNombre());
        Monedero monedero = monederoRepositorio.findByUsuarioId(usuario.getId())
                .orElseThrow(() -> new IllegalStateException("Monedero no encontrado"));
        httpSession.setAttribute("monedero",monedero);
        double saldo = 0;
        if (monedero != null && monedero.getDeposito() != null) {
            for (Deposito c : monedero.getDeposito()) {
                saldo += c.getDeposito();
            }
        }
        model.addAttribute("saldo", "$" + monedero.getSaldo());
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
        Usuario usuario=(Usuario)httpSession.getAttribute("usuario");
        List<Transaccion>historial=apiController.obtenerHistorial(usuario.getId());
        model.addAttribute("historial",historial);
        return "home/prueba";
    }
    @PostMapping("/historial")
    public String verHistorial(){
        return "redirect:/cuenta";
    }

    @PostMapping("/envio")
    public String enviar(@ModelAttribute("Transferir") Transferir transferir,HttpSession httpSession,Model model){
     Monedero monedero=(Monedero)httpSession.getAttribute("monedero");
     httpSession.setAttribute("transferir",transferir);
        model.addAttribute("saldo",monedero.getSaldo());
        return "home/Envio";
    }
    @GetMapping("/retiro")
    public String retiros(){
        return "home/Retirar";
    }

    @PostMapping("/retiro")
    public String retiros(@ModelAttribute("Retiro") Retiro retiro,HttpSession session,Model model){
        session.setAttribute("retirar",retiro);
        Monedero monedero=(Monedero) session.getAttribute("monedero");
        model.addAttribute("sal",monedero.getSaldo());
        return "home/Retirar";
    }


}
