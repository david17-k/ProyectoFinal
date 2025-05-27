package com.proyectoestructura.estructuraDatos.Controller;


import com.proyectoestructura.estructuraDatos.model.Deposito;
import com.proyectoestructura.estructuraDatos.model.ProgramarTransferencias;
import com.proyectoestructura.estructuraDatos.model.Retiro;
import com.proyectoestructura.estructuraDatos.model.service.TransaccionService;
import com.proyectoestructura.estructuraDatos.repositorio.ProgramarTransferenciaRepositorio;
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
    public String programarRetiro(@ModelAttribute("programarRetiros")ProgramarTransferencias programarTransferencias) throws Exception {
        Retiro retiro=new Retiro();
        retiro.setMonto(programarTransferencias.getMonto());
        programarTransferencias.getRetiro().push(retiro);
        transaccionService.programarRetiro(programarTransferencias);
        programarTransferenciaRepositorio.save(programarTransferencias);
        return "home/programarRetiro";
    }

}
