package com.kevinmorales.ventas.repository;

import com.kevinmorales.ventas.entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosRepository extends JpaRepository<Productos, Integer> {
}
