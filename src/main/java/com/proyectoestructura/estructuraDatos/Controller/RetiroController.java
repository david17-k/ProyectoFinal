package com.proyectoestructura.estructuraDatos.Controller;


import com.proyectoestructura.estructuraDatos.model.Monedero;
import com.proyectoestructura.estructuraDatos.model.Retiro;
import com.proyectoestructura.estructuraDatos.model.Transaccion;
import com.proyectoestructura.estructuraDatos.model.Usuario;
import com.proyectoestructura.estructuraDatos.repositorio.HistorialRepositorio;
import com.proyectoestructura.estructuraDatos.repositorio.MonederoRepositorio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.annotation.ApplicationScope;

import java.time.LocalTime;

@Controller
public class RetiroController {

    @Autowired
    private MonederoRepositorio monederoRepositorio;

    @Autowired
    private HistorialRepositorio historialRepositorio;
    @Autowired
    private ApiController apiController;

    @GetMapping("/retirar")
    public String mostrarFormularioRetiro(Model model, HttpSession session) {
        model.addAttribute("retiro", new Retiro());

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        Monedero monedero = monederoRepositorio.findByUsuarioId(usuario.getId())
                .orElseThrow(() -> new IllegalStateException("Monedero no encontrado"));
        model.addAttribute("saldo", "$" + monedero.getSaldo());

        return "home/Retirar";
    }

    @PostMapping("/retirar")
    public String procesarRetiro(@ModelAttribute("retiro") Retiro retiro, BindingResult result,
                                 HttpSession session, Model model) {
        if (result.hasErrors()) {
            return "home/Retirar";
        }

        Usuario usuario = (Usuario) session.getAttribute("usuario");
        Monedero monedero = monederoRepositorio.findByUsuarioId(usuario.getId())
                .orElseThrow(() -> new IllegalStateException("Monedero no encontrado"));

        if (monedero.getSaldo() < retiro.getMonto()) {
            model.addAttribute("error", "Saldo insuficiente.");
            model.addAttribute("saldo", "$" + monedero.getSaldo());
            return "home/Deposito";
        }

        monedero.setSaldo(monedero.getSaldo() - retiro.getMonto());
        int puntosGanados=((int)retiro.getMonto()/100)*2;
        monedero.setPuntos( monedero.getPuntos()+puntosGanados);
        monederoRepositorio.save(monedero);
        session.setAttribute("monedero", monedero);
        Transaccion transaccion=new Transaccion();
        transaccion.setFecha(LocalTime.now());
        transaccion.setMoneda("Peso");
        transaccion.setUsuario(usuario);
        transaccion.setMonto(retiro.getMonto());
        transaccion.setTipo("Retiro");
        transaccion.setDescripcion("Retiro de cuenta");
        historialRepositorio.save(transaccion);
        apiController.guardarHistorial(transaccion);
        return "redirect:/cuenta";
    }
}



