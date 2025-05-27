package com.proyectoestructura.estructuraDatos.Controller;


import com.proyectoestructura.estructuraDatos.estructura.Cola;
import com.proyectoestructura.estructuraDatos.estructura.Lista;
import com.proyectoestructura.estructuraDatos.model.Deposito;
import com.proyectoestructura.estructuraDatos.model.Monedero;
import com.proyectoestructura.estructuraDatos.model.ProgramarTransferencias;
import com.proyectoestructura.estructuraDatos.model.Retiro;
import com.proyectoestructura.estructuraDatos.model.service.TransaccionService;
import com.proyectoestructura.estructuraDatos.repositorio.ProgramarTransferenciaRepositorio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProgramarController {

    @Autowired
    ProgramarTransferenciaRepositorio programarTransferenciaRepositorio;
    @Autowired
    TransaccionService transaccionService;

    @GetMapping("/programaRetiro")
    public String programarRetiro(){
        return "home/programarRetiro";
    }

    @PostMapping("/programaRetiro")
    public String programarRetiro(@ModelAttribute("programarRetiros")ProgramarTransferencias programarTransferencias, HttpSession session) throws Exception {
        Retiro retiro=new Retiro();
        Cola<Retiro> retiroLista=new Cola<>();
        Monedero monedero=(Monedero)session.getAttribute("monedero");
        retiro.setMonto(programarTransferencias.getMonto());
        retiroLista.push(retiro);
        programarTransferencias.setRetiro(retiroLista);
        programarTransferencias.setUsuario(monedero.getUsuario());
        programarTransferencias.serializarTransacciones();
        programarTransferenciaRepositorio.save(programarTransferencias);
        transaccionService.programarRetiro();
        return "home/programarRetiro";
    }

}
