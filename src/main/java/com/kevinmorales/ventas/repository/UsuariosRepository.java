package com.kevinmorales.ventas.repository;

import com.kevinmorales.ventas.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuariosRepository extends JpaRepository<Usuarios, Integer> {
    Optional<Usuarios> findByUsernameOrEmail(String username, String email);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
