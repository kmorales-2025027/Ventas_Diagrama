package com.kevinmorales.ventas.service;

import com.kevinmorales.ventas.entity.DetalleVenta;
import java.util.List;

public interface DetalleVentaService {
    List<DetalleVenta> listar();
    DetalleVenta buscarPorId(Integer id);
    DetalleVenta crear(DetalleVenta detalleVenta);
    DetalleVenta actualizar(Integer id, DetalleVenta detalleVenta);
    void eliminar(Integer id);
}
