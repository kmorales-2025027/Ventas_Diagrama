package com.kevinmorales.ventas.service;

import com.kevinmorales.ventas.entity.Clientes;
import com.kevinmorales.ventas.exception.ResourceNotFoundException;
import com.kevinmorales.ventas.repository.ClientesRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientesServiceImpl implements ClientesService {
    private final ClientesRepository clientesRepository;

    public ClientesServiceImpl(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    @Override
    public List<Clientes> listar() {
        return clientesRepository.findAll();
    }

    @Override
    public Clientes buscarPorId(Long dpi) {
        return clientesRepository.findById(dpi)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el cliente con el DPI No. " + dpi + "."));
    }

    @Override
    public Clientes crear(Clientes clientes) {
        return clientesRepository.save(clientes);
    }

    @Override
    public Clientes actualizar(Long dpi, Clientes clientes) {
        Clientes existente = buscarPorId(dpi);

        existente.setDpiCliente(clientes.getDpiCliente());
        existente.setNombreCliente(clientes.getNombreCliente());
        existente.setApellidoCliente(clientes.getApellidoCliente());
        existente.setDireccion(clientes.getDireccion());
        existente.setEstado(clientes.getEstado());

        return clientesRepository.save(existente);
    }

    @Override
    public void eliminar(Long dpi) {
        if (!clientesRepository.existsById(dpi)) {
            throw new ResourceNotFoundException("No se encontró el cliente con el DPI No. " + dpi + ".");
        }
        clientesRepository.deleteById(dpi);
    }
}
