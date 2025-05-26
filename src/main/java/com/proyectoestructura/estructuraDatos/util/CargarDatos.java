package com.proyectoestructura.estructuraDatos.util;

import com.proyectoestructura.estructuraDatos.estructura.Lista;
import com.proyectoestructura.estructuraDatos.model.Usuario;
import com.proyectoestructura.estructuraDatos.repositorio.UsuarioRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CargarDatos implements CommandLineRunner {
  private final UsuarioRepositorio usuarioRepositorio;

    public CargarDatos(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }


    @Override
    public void run(String... args) throws Exception {
        if (usuarioRepositorio.findAll().isEmpty()) {
            usuarioRepositorio.save(new Usuario("Castillo", "100067",  "123","David"));
            usuarioRepositorio.save(new Usuario("Perez", "100090",  "1","Juan"));
        }
    }

    public Lista<Usuario> obtenerUsuarios() {
        Lista<Usuario>usuarioLista=new Lista<>();
        for(Usuario usuario:usuarioRepositorio.findAll()){
            usuarioLista.agregarPrimera(usuario);
        }
        return usuarioLista;
    }




}
