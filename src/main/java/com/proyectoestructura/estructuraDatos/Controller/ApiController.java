package com.proyectoestructura.estructuraDatos.Controller;


import com.proyectoestructura.estructuraDatos.estructura.Lista;
import com.proyectoestructura.estructuraDatos.model.Deposito;
import com.proyectoestructura.estructuraDatos.model.Monedero;
import com.proyectoestructura.estructuraDatos.model.Transaccion;
import com.proyectoestructura.estructuraDatos.model.Usuario;

import com.proyectoestructura.estructuraDatos.repositorio.HistorialRepositorio;
import com.proyectoestructura.estructuraDatos.repositorio.MonederoRepositorio;
import com.proyectoestructura.estructuraDatos.repositorio.UsuarioRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {


    private final UsuarioRepositorio usuarioRepositorio;
    private final HistorialRepositorio historialRepositorio;
    private final MonederoRepositorio monederoRepositorio;


    public ApiController(UsuarioRepositorio usuarioRepositorio, HistorialRepositorio historialRepositorio,MonederoRepositorio monederoRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.historialRepositorio = historialRepositorio;
        this.monederoRepositorio= monederoRepositorio;
    }

    @GetMapping
    public List<Usuario> obtenerUsuario() {
        Lista<Usuario> listaUsuario = new Lista<>();
        for (Usuario usuario : usuarioRepositorio.findAll()) {
            listaUsuario.agregarPrimera(usuario);
        }
        return listaUsuario.toList();
    }


    @PostMapping("/guardarHistorial")
    public Transaccion guardarHistorial(@RequestBody Transaccion transaccion){
        return historialRepositorio.save(transaccion);
    }

@GetMapping("/historial")
    public List<Transaccion>obtenerHistorial(){
        System.out.println("Historial");
        Lista<Transaccion>historial=new Lista<>();
        for(Transaccion h:historialRepositorio.findAll()){
            System.out.println("Transaccion"+ h.toString());
            historial.agregarPrimera(h);
        }
        return historial.toList();
    }

    @PostMapping("/guardarTransaccion")
    public Monedero guardarTransaccion(@RequestBody Monedero monedero){
        return monederoRepositorio.save(monedero);
    }

    @GetMapping("/transaccion")
    public List<Deposito>obtenerTransaccion(){
        Lista<Deposito>depositos=new Lista<>();
        for(Monedero deposito:monederoRepositorio.findAll()){
            depositos=deposito.getDeposito();
        }
        return depositos.toList();
    }



}

