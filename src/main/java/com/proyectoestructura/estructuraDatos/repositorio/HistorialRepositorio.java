package com.proyectoestructura.estructuraDatos.repositorio;


import com.proyectoestructura.estructuraDatos.model.Monedero;
import com.proyectoestructura.estructuraDatos.model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialRepositorio extends JpaRepository<Transaccion,Long> {
    List<Transaccion>findByUsuarioId(Long usuarioId);
}
