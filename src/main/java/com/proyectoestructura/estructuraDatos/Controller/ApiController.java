package com.proyectoestructura.estructuraDatos.Controller;


import com.proyectoestructura.estructuraDatos.estructura.Lista;
import com.proyectoestructura.estructuraDatos.model.Deposito;
import com.proyectoestructura.estructuraDatos.model.Monedero;
import com.proyectoestructura.estructuraDatos.model.Transaccion;
import com.proyectoestructura.estructuraDatos.model.Usuario;
import com.proyectoestructura.estructuraDatos.repositorio.CuentaRepositorio;
import com.proyectoestructura.estructuraDatos.repositorio.HistorialRepositorio;
import com.proyectoestructura.estructuraDatos.repositorio.UsuarioRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {


    private final UsuarioRepositorio usuarioRepositorio;
    private final CuentaRepositorio cuentaRepositorio;
    private final HistorialRepositorio historialRepositorio;


    public ApiController(UsuarioRepositorio usuarioRepositorio, CuentaRepositorio cuentaRepositorio, HistorialRepositorio historialRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.cuentaRepositorio = cuentaRepositorio;
        this.historialRepositorio = historialRepositorio;
    }

    @GetMapping
    public List<Usuario> obtenerUsuario() {
        Lista<Usuario> listaUsuario = new Lista<>();
        for (Usuario usuario : usuarioRepositorio.findAll()) {
            listaUsuario.agregarPrimera(usuario);
        }
        return listaUsuario.toList();
    }

    @PostMapping("/usuarios")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @PostMapping("/depositos")
    public ResponseEntity<Deposito> guardarDeposito(@RequestBody Deposito deposito) {
        try {
            Monedero monedero = cuentaRepositorio.findById(1L).orElse(new Monedero());
            if (monedero.getDepositoJson() != null) {
                monedero.getDeposito();
            }
            monedero.getDeposito().agregarPrimera(deposito);
            monedero.setDeposito(monedero.getDeposito());
            cuentaRepositorio.save(monedero);

            return ResponseEntity.ok(deposito);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
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

}

