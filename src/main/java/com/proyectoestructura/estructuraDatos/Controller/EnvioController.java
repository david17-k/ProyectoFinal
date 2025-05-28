package com.proyectoestructura.estructuraDatos.Controller;


import com.proyectoestructura.estructuraDatos.model.Monedero;
import com.proyectoestructura.estructuraDatos.model.Transaccion;
import com.proyectoestructura.estructuraDatos.model.Transferir;
import com.proyectoestructura.estructuraDatos.model.Usuario;
import com.proyectoestructura.estructuraDatos.repositorio.HistorialRepositorio;
import com.proyectoestructura.estructuraDatos.repositorio.MonederoRepositorio;
import com.proyectoestructura.estructuraDatos.repositorio.UsuarioRepositorio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@Controller
public class EnvioController {

    @Autowired
    private ApiController apiController;
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private MonederoRepositorio monederoRepositorio;
    @Autowired
    private HistorialRepositorio historialRepositorio;

    @GetMapping("/enviar")
    public String enviar(Model model,HttpSession httpSession){
        Usuario usuario=(Usuario)httpSession.getAttribute("Usuario");
        Monedero monedero=(Monedero)httpSession.getAttribute("monedero");
        model.addAttribute("saldo","$"+monedero.getSaldo());
        return "home/Envio";
    }

    @PostMapping("/enviar")
    public String enviar(@ModelAttribute("Transferir") Transferir transferir, BindingResult bindingResult, HttpSession session,Model model){
        if(bindingResult.hasErrors()){
            return "home/Envio";
        }
        Usuario sesion=(Usuario)session.getAttribute("usuario");
        Monedero monedero=monederoRepositorio.findByUsuarioId(sesion.getId()).orElseThrow(()->new IllegalStateException("No exite monedero"));
        if(monedero.getSaldo()< transferir.getMonto()){
            model.addAttribute("error", "Saldo insuficiente para la transferencia.");
            model.addAttribute("saldo", "$" + monedero.getSaldo());
            System.out.println("Saldo Insuficiente");
            return "home/Envio";
        }else {
            Transaccion transaccion=new Transaccion();
            double actulizarSaldo=0;
            List<Usuario> usuario = apiController.obtenerUsuario();
            for (Usuario c : usuario) {
                if (transferir.getIdUsuario().equals(c.getIdCuenta())) {
                    double calcular = transferir.getMonto() + c.getMonedero().getSaldo();
                    c.getMonedero().setSaldo(calcular);
                    usuarioRepositorio.save(c);
                    actulizarSaldo= monedero.getSaldo()-transferir.getMonto();
                    monedero.setSaldo(actulizarSaldo);
                    int puntosGanados=((int)transferir.getMonto()/100)*3;
                    monedero.setPuntos(monedero.getPuntos()+puntosGanados);
                    monederoRepositorio.save(monedero);
                    transaccion.setTipo("Transferencia");
                    transaccion.setMonto(transferir.getMonto());
                    transaccion.setUsuario(sesion);
                    transaccion.setMoneda("Peso");
                    transaccion.setFecha(LocalTime.now());
                    historialRepositorio.save(transaccion);
                    apiController.guardarHistorial(transaccion);
                }
            }
        }
        return "redirect:/cuenta";

    }
}
