package com.proyectoestructura.estructuraDatos.repositorio;

import com.proyectoestructura.estructuraDatos.model.Monedero;
import com.proyectoestructura.estructuraDatos.model.ProgramarTransferencias;
import com.proyectoestructura.estructuraDatos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProgramarTransferenciaRepositorio extends JpaRepository<ProgramarTransferencias,Long> {
    Optional<ProgramarTransferencias>findByUsuarioId(Long id);


    @Modifying
    @Query("update Monedero m set m.saldo = m.saldo + :monto where m.id = :id")
    void depositar(@Param("id")Long id,@Param("monto")double monto);

    @Modifying
    @Query("update Monedero m set m.saldo = m.saldo - :monto where m.id = :id")
    void retirar(@Param("id")Long id,@Param("monto")double monto);

}
