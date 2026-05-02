package com.kevinmorales.ventas.service;

import com.kevinmorales.ventas.entity.Productos;
import java.util.List;

public interface ProductosService {
    List<Productos> listar();
    Productos buscarPorId(Integer id);
    Productos crear(Productos productos);
    Productos actualizar(Integer id, Productos productos);
    void eliminar(Integer id);
}
