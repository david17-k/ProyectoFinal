package com.proyectoestructura.estructuraDatos.Controller;


import com.proyectoestructura.estructuraDatos.model.Monedero;
import com.proyectoestructura.estructuraDatos.model.Retiro;
import com.proyectoestructura.estructuraDatos.model.Usuario;
import com.proyectoestructura.estructuraDatos.repositorio.MonederoRepositorio;
import com.proyectoestructura.estructuraDatos.repositorio.UsuarioRepositorio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class RetiroController {

    @Autowired
    MonederoRepositorio monederoRepositorio;
@Autowired
    UsuarioRepositorio usuarioRepositorio;
@Autowired
ApiController apiController;
    @GetMapping("/retirar")
    public String retiro(){
        return "home/Retirar";
    }

    @PostMapping("/retirar")
    public String reitro(@ModelAttribute("Retiro") Retiro retiro, BindingResult bindingResult, Model model, HttpSession session){
        if(bindingResult.hasErrors()){
            return "home/Retiro";
        }
        Usuario sesion=(Usuario) session.getAttribute("usuario");
        Monedero monedero=monederoRepositorio.findByUsuarioId(sesion.getId()).orElseThrow(()->new IllegalStateException("No exite cuenta"));
        if(monedero.getSaldo()< retiro.getMonto()) {
            model.addAttribute("error", "Saldo insuficiente para la transferencia.");
            model.addAttribute("saldo", "$" + monedero.getSaldo());
            System.out.println("Saldo Insuficiente");
            return "home/Retirar";
        }else{
                    double calcular = monedero.getSaldo()-retiro.getMonto();
                    usuarioRepositorio.save(sesion);
                    monedero.setSaldo(calcular);
                    monederoRepositorio.save(monedero);
            return "redirect:/cuenta";
        }

    }


}
