package com.proyectoestructura.estructuraDatos.repositorio;

import com.proyectoestructura.estructuraDatos.model.Monedero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonederoRepositorio extends JpaRepository<Monedero,Long> {
}
