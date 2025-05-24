package com.proyectoestructura.estructuraDatos.repositorio;

import com.proyectoestructura.estructuraDatos.model.Monedero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepositorio extends JpaRepository<Monedero,Long> {

}
