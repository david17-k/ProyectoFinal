package com.proyectoestructura.estructuraDatos.repositorio;


import com.proyectoestructura.estructuraDatos.model.Monedero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialRepositorio extends JpaRepository<Monedero,Long> {
}
