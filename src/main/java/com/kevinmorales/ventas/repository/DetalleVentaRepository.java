package com.kevinmorales.ventas.repository;

import com.kevinmorales.ventas.entity.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Integer> {
}
