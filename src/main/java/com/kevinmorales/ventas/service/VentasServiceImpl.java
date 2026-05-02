package com.kevinmorales.ventas.service;

import com.kevinmorales.ventas.entity.Ventas;
import com.kevinmorales.ventas.exception.ResourceNotFoundException;
import com.kevinmorales.ventas.repository.VentasRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VentasServiceImpl implements VentasService {
    private final VentasRepository ventasRepository;

    public VentasServiceImpl(VentasRepository ventasRepository) {
        this.ventasRepository = ventasRepository;
    }

    @Override
    public List<Ventas> listar() {
        return ventasRepository.findAll();
    }

    @Override
    public Ventas buscarPorId(Integer id) {
        return ventasRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró la venta No. " + id + "."));
    }

    @Override
    public Ventas crear(Ventas ventas) {
        ventas.setCodigoVenta(null);
        return ventasRepository.save(ventas);
    }

    @Override
    public Ventas actualizar(Integer id, Ventas ventas) {
        Ventas existente = buscarPorId(id);

        existente.setFechaVenta(ventas.getFechaVenta());
        existente.setTotal(ventas.getTotal());
        existente.setEstado(ventas.getEstado());
        existente.setClientesDpiCliente(ventas.getClientesDpiCliente());
        existente.setUsuariosCodigoUsuario(ventas.getUsuariosCodigoUsuario());

        return ventasRepository.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
        if (!ventasRepository.existsById(id)) {
            throw new ResourceNotFoundException("No se encontró la venta No. " + id + ".");
        }
        ventasRepository.deleteById(id);
    }
}
