package com.kevinmorales.ventas.service;

import com.kevinmorales.ventas.entity.Usuarios;
import java.util.List;

public interface UsuariosService {
    List<Usuarios> listar();
    Usuarios buscarPorId(Integer id);
    Usuarios crear(Usuarios usuarios);
    Usuarios actualizar(Integer id, Usuarios usuarios);
    void eliminar(Integer id);

    Usuarios registrar(Usuarios usuarios);
}
