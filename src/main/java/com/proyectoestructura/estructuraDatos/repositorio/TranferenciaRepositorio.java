package com.proyectoestructura.estructuraDatos.repositorio;


import com.proyectoestructura.estructuraDatos.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranferenciaRepositorio extends JpaRepository<Transferencia,Long> {

}
