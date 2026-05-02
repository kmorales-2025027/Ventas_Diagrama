package com.kevinmorales.ventas.repository;

import com.kevinmorales.ventas.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {
}
