package com.proyectoestructura.estructuraDatos.repositorio;

import com.proyectoestructura.estructuraDatos.model.ProgramarTransferencias;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgramarTransferenciaRepositorio extends JpaRepository<ProgramarTransferencias,Long> {
    Optional<ProgramarTransferencias>findByUsuarioId(Long idUsuario);

}
