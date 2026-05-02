package com.kevinmorales.ventas.service;

import com.kevinmorales.ventas.entity.DetalleVenta;
import com.kevinmorales.ventas.exception.ResourceNotFoundException;
import com.kevinmorales.ventas.repository.DetalleVentaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService {
    private final DetalleVentaRepository detalleVentaRepository;

    public DetalleVentaServiceImpl(DetalleVentaRepository detalleVentaRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
    }

    @Override
    public List<DetalleVenta> listar() {
        return detalleVentaRepository.findAll();
    }

    @Override
    public DetalleVenta buscarPorId(Integer id) {
        return detalleVentaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el detalle de venta No. " + id + "."));
    }

    @Override
    public DetalleVenta crear(DetalleVenta detalleVenta) {
        detalleVenta.setCodigoDetalleVenta(null);
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public DetalleVenta actualizar(Integer id, DetalleVenta detalleVenta) {
        DetalleVenta existente = buscarPorId(id);

        existente.setCantidad(detalleVenta.getCantidad());
        existente.setPrecioUnitario(detalleVenta.getPrecioUnitario());
        existente.setSubtotal(detalleVenta.getSubtotal());
        existente.setProductosCodigoProducto(detalleVenta.getProductosCodigoProducto());
        existente.setVentasCodigoVenta(detalleVenta.getVentasCodigoVenta());

        return detalleVentaRepository.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
        if (!detalleVentaRepository.existsById(id)) {
            throw new ResourceNotFoundException("No se encontró el detalle de venta No. " + id + ".");
        }
        detalleVentaRepository.deleteById(id);
    }
}
