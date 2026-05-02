package com.kevinmorales.ventas.repository;

import com.kevinmorales.ventas.entity.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentasRepository extends JpaRepository<Ventas, Integer> {
}
