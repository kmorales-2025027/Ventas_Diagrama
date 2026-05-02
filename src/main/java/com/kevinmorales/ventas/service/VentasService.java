package com.kevinmorales.ventas.service;

import com.kevinmorales.ventas.entity.Ventas;
import java.util.List;

public interface VentasService {
    List<Ventas> listar();
    Ventas buscarPorId(Integer id);
    Ventas crear(Ventas ventas);
    Ventas actualizar(Integer id, Ventas ventas);
    void eliminar(Integer id);
}
