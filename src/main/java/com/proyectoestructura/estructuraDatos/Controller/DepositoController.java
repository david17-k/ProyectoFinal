package com.proyectoestructura.estructuraDatos.Controller;

import com.proyectoestructura.estructuraDatos.model.Deposito;
import com.proyectoestructura.estructuraDatos.model.Monedero;
import com.proyectoestructura.estructuraDatos.model.Transaccion;
import com.proyectoestructura.estructuraDatos.model.Usuario;
import com.proyectoestructura.estructuraDatos.repositorio.HistorialRepositorio;
import com.proyectoestructura.estructuraDatos.repositorio.MonederoRepositorio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;


@Controller
public class DepositoController {

    @Autowired
   private ModelController modelController;
    @Autowired
    private final MonederoRepositorio monederoRepositorio;
    @Autowired
    private final HistorialRepositorio historialRepositorio;
    @Autowired
    private ApiController apiController;

    public DepositoController(MonederoRepositorio monederoRepositorio, HistorialRepositorio historialRepositorio) {
        this.monederoRepositorio = monederoRepositorio;
        this.historialRepositorio = historialRepositorio;
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
        Transaccion transaccion=new Transaccion();
        transaccion.setTipo("Deposito");
        transaccion.setMonto(deposito.getDeposito());
        transaccion.setMoneda("$");
        transaccion.setFecha(LocalTime.now());
        transaccion.setUsuario(usuario);
        monedero.getHistorial().agregarPrimera(transaccion);
        monederoRepositorio.save(monedero);
        historialRepositorio.save(transaccion);
        apiController.guardarHistorial(transaccion);
        httpSession.setAttribute("monedero", monedero);
        System.out.println(monedero.getSaldo());
        monedero.getDeposito().mostrarContenido();
        return "redirect:/cuenta";
    }



}
