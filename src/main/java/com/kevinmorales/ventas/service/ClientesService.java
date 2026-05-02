package com.kevinmorales.ventas.service;

import com.kevinmorales.ventas.entity.Clientes;
import java.util.List;

public interface ClientesService {
    List<Clientes> listar();
    Clientes buscarPorId(Long id);
    Clientes crear(Clientes clientes);
    Clientes actualizar(Long id, Clientes clientes);
    void eliminar(Long id);
}
