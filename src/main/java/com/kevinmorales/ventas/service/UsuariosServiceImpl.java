package com.kevinmorales.ventas.service;

import com.kevinmorales.ventas.entity.Usuarios;
import com.kevinmorales.ventas.exception.ResourceNotFoundException;
import com.kevinmorales.ventas.repository.UsuariosRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuariosServiceImpl implements UsuariosService {
    private final UsuariosRepository usuariosRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuariosServiceImpl(UsuariosRepository usuariosRepository, PasswordEncoder passwordEncoder) {
        this.usuariosRepository = usuariosRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Usuarios> listar() {
        return usuariosRepository.findAll();
    }

    @Override
    public Usuarios buscarPorId(Integer id) {
        return usuariosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el usuario No. " + id + "."));
    }

    @Override
    public Usuarios crear(Usuarios usuarios) {
        usuarios.setCodigoUsuario(null);
        usuarios.setPassword(passwordEncoder.encode(usuarios.getPassword()));
        usuarios.setRol("USER");

        return usuariosRepository.save(usuarios);
    }

    @Override
    public Usuarios actualizar(Integer id, Usuarios usuarios) {
        Usuarios existente = buscarPorId(id);
        String hash = passwordEncoder.encode(usuarios.getPassword());

        existente.setUsername(usuarios.getUsername());
        existente.setPassword(hash);
        existente.setEmail(usuarios.getEmail());
        existente.setRol(usuarios.getRol());
        existente.setEstado(usuarios.getEstado());

        return usuariosRepository.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
        if (!usuariosRepository.existsById(id)) {
            throw new ResourceNotFoundException("No se encontró el usuario No. " + id + ".");
        }
        usuariosRepository.deleteById(id);
    }

    @Override
    public Usuarios registrar(Usuarios usuarios) {
        if (usuariosRepository.existsByUsername(usuarios.getUsername())) {
            throw new RuntimeException("El nombre de usuario '" + usuarios.getUsername() + "' ya está en uso.");
        }
        if (usuariosRepository.existsByEmail(usuarios.getEmail())) {
            throw new RuntimeException("El correo '" + usuarios.getEmail() + "' ya ha sido registrado.");
        }
        usuarios.setCodigoUsuario(null);
        usuarios.setPassword(passwordEncoder.encode(usuarios.getPassword()));

        return usuariosRepository.save(usuarios);
    }
}
