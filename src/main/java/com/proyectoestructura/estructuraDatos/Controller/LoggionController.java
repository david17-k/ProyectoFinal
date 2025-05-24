package com.proyectoestructura.estructuraDatos.Controller;


import com.proyectoestructura.estructuraDatos.estructura.Lista;
import com.proyectoestructura.estructuraDatos.model.Monedero;
import com.proyectoestructura.estructuraDatos.model.Usuario;
import com.proyectoestructura.estructuraDatos.util.CargarDatos;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class LoggionController {

  private final ModelController modelController;
   private final CargarDatos cargarDatos;

    @Autowired
    public LoggionController(ModelController modelController, CargarDatos cargarDatos) {
        this.modelController = modelController;
        this.cargarDatos = cargarDatos;
    }


    @GetMapping("/loggin")
    public String mostrarFormularioLogin() {
        return "home/login";
    }

    @PostMapping("/log")
    public String procesarLogin(
            @RequestParam("usuario") String usuario,
            @RequestParam("password") String contrasena, HttpSession httpSession) {
        Lista<Usuario>usuarios=cargarDatos.obtenerUsuarios();
        for(Usuario c:usuarios){
            if(c.getNombre().equals(usuario) && c.getIdCuenta().equals(contrasena)){
               httpSession.setAttribute("usuario",c);
                if (httpSession.getAttribute("monedero") == null) {
                    Monedero monedero = new Monedero();
                    monedero.getUsuarioLista().agregarPrimera(c);
                    httpSession.setAttribute("monedero", monedero);
                }
                return "redirect:/cuenta";
            }

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






