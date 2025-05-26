package com.proyectoestructura.estructuraDatos.repositorio;

import com.proyectoestructura.estructuraDatos.model.Monedero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MonederoRepositorio extends JpaRepository<Monedero,Long> {
   Optional<Monedero> findByUsuarioId(Long id);
}
