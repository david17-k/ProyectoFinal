package com.proyectoestructura.estructuraDatos.Controller;



import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@SpringBootApplication
public class HomeControler {

   @GetMapping("/cuenta")
    public String cuenta(Model model){
        model.addAttribute("title","Hola puta");
        model.addAttribute("subtitle","Perra HP");
        return "home/cuenta";
    }

    public static void main(String[] args) {
        SpringApplication.run(HomeControler.class,args);
    }



}