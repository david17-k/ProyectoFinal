package com.proyectoestructura.estructuraDatos.Controller;


import com.proyectoestructura.estructuraDatos.model.Usuario;
import com.proyectoestructura.estructuraDatos.repositorio.UsuarioRepositorio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CrearCuenta {
@Autowired
   private ModelController modelController;
@Autowired
private final UsuarioRepositorio usuarioRepositorio;

    public CrearCuenta(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }


    @GetMapping("/crearcuenta")
    public String log(Model model){
        return "home/crearcuenta";
    }

    @PostMapping("/crearcuenta")
    public String crearCuenta(@ModelAttribute("Usuario") Usuario usuario, BindingResult bindingResult, HttpSession httpSession){
        if(bindingResult.hasErrors()){
            System.out.println("Fallo");
            return "home/crearcuenta";
        }
        modelController.crearCuenta(usuario);
        usuarioRepositorio.save(usuario);
        return "redirect:/loggin";
    }


}
