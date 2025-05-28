package com.proyectoestructura.estructuraDatos.util;

import com.proyectoestructura.estructuraDatos.estructura.Lista;
import com.proyectoestructura.estructuraDatos.model.Monedero;
import com.proyectoestructura.estructuraDatos.model.Usuario;
import com.proyectoestructura.estructuraDatos.repositorio.MonederoRepositorio;
import com.proyectoestructura.estructuraDatos.repositorio.UsuarioRepositorio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CargarDatos implements CommandLineRunner {
  private final UsuarioRepositorio usuarioRepositorio;
  private final MonederoRepositorio monederoRepositorio;

    public CargarDatos(UsuarioRepositorio usuarioRepositorio, MonederoRepositorio monederoRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.monederoRepositorio = monederoRepositorio;
    }


    @Override
    public void run(String... args) throws Exception {
        if (usuarioRepositorio.findAll().isEmpty()) {
            Usuario usuario1 = new Usuario("Castillo", "100067", "123", "David");
            Usuario usuario2 = new Usuario("Perez", "100090", "1", "Juan");

            usuarioRepositorio.save(usuario1);
            usuarioRepositorio.save(usuario2);


            Monedero monedero1 = new Monedero();
            monedero1.setUsuario(usuario1);
            monedero1.setSaldo(50000);
            monedero1.setPuntos(500);
            monederoRepositorio.save(monedero1);

            Monedero monedero2 = new Monedero();
            monedero2.setSaldo(20000);
            monedero2.setPuntos(4999);
            monedero2.setUsuario(usuario2);
            monederoRepositorio.save(monedero2);
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
