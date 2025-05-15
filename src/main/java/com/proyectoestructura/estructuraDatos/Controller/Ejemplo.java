package com.proyectoestructura.estructuraDatos.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Ejemplo {
    @GetMapping("/hola")
    public String hola(){
        return "Hola care de nalga";
    }

    @GetMapping("/name/{nombre}/{ID}")
    public String datos(@PathVariable String nombre, @PathVariable int ID){
        return "Hola"+ nombre + "ID"+ ID;
    }




}
