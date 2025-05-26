package com.proyectoestructura.estructuraDatos.Controller;

import com.proyectoestructura.estructuraDatos.model.Deposito;
import com.proyectoestructura.estructuraDatos.model.Monedero;
import com.proyectoestructura.estructuraDatos.model.Transaccion;
import com.proyectoestructura.estructuraDatos.model.Usuario;
import com.proyectoestructura.estructuraDatos.repositorio.MonederoRepositorio;
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
    private final MonederoRepositorio monederoRepositorio;

    public DepositoController(MonederoRepositorio monederoRepositorio) {
        this.monederoRepositorio = monederoRepositorio;
    }

    @GetMapping("/deposito")
   public String depositar(Model model){
       return "home/Deposito";
   }

    @PostMapping("/deposito")
    public String depositar(@ModelAttribute("Deposito") Deposito deposito, BindingResult bindingResult, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "home/Deposito";
        }

        Usuario usuario = (Usuario) httpSession.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/login";
        }

        Monedero monedero = monederoRepositorio.findByUsuarioId(usuario.getId())
                .orElseThrow(() -> new IllegalStateException("Monedero no encontrado para el usuario"));

        monedero.getDeposito().agregarPrimera(deposito);
        monedero.setSaldo(monedero.getSaldo() + deposito.getDeposito());

        try {
            monedero.serializarTodo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        monederoRepositorio.save(monedero);
        httpSession.setAttribute("monedero", monedero);
        monedero.getDeposito().mostrarContenido();
        return "redirect:/cuenta";
    }


}
