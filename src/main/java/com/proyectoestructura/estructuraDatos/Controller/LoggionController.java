package com.proyectoestructura.estructuraDatos.Controller;


import com.proyectoestructura.estructuraDatos.estructura.Lista;
import com.proyectoestructura.estructuraDatos.model.Monedero;
import com.proyectoestructura.estructuraDatos.model.Usuario;
import com.proyectoestructura.estructuraDatos.repositorio.MonederoRepositorio;
import com.proyectoestructura.estructuraDatos.repositorio.UsuarioRepositorio;
import com.proyectoestructura.estructuraDatos.util.CargarDatos;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.Optional;

@Controller
public class LoggionController {

    private final ModelController modelController;
    private final CargarDatos cargarDatos;
    private final UsuarioRepositorio usuarioRepositorio;
    private final MonederoRepositorio monederoRepositorio;

    @Autowired
    public LoggionController(ModelController modelController, CargarDatos cargarDatos, UsuarioRepositorio usuarioRepositorio, MonederoRepositorio monederoRepositorio) {
        this.modelController = modelController;
        this.cargarDatos = cargarDatos;
        this.usuarioRepositorio = usuarioRepositorio;
        this.monederoRepositorio = monederoRepositorio;
    }


    @GetMapping("/loggin")
    public String mostrarFormularioLogin() {
        return "home/login";
    }

    @PostMapping("/log")
    public String procesarLogin(
            @RequestParam("usuario") String usuario,
            @RequestParam("password") String contrasena,
            HttpSession httpSession) {
        Optional<Usuario> encontrado = usuarioRepositorio.findByNombreAndIdCuenta(usuario, contrasena);
        if (encontrado.isPresent()) {
            Usuario usuarioLog = encontrado.get();
            httpSession.setAttribute("usuario", usuarioLog);

         
            Monedero monedero = monederoRepositorio
                    .findByUsuarioId(usuarioLog.getId())
                    .orElseGet(() -> {
                        Monedero nuevo = new Monedero();
                        nuevo.setUsuario(usuarioLog);
                        nuevo.setSaldo(0);
                        return monederoRepositorio.save(nuevo);
                    });

            httpSession.setAttribute("monedero", monedero);
            return "redirect:/cuenta";
        }

        return "home/login";


}


    @GetMapping ("/crear")
    public String registrarse(Model model){
        model.addAttribute("usuario",new Usuario());
        return "home/crearcuenta" ;
    }

    @PostMapping("/crear")
    public String procesarRegistro(@ModelAttribute("usuario")Usuario usuario){
        return "redirect: /login";
    }


}






