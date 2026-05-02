package com.kevinmorales.ventas.service;

import com.kevinmorales.ventas.entity.Productos;
import com.kevinmorales.ventas.exception.ResourceNotFoundException;
import com.kevinmorales.ventas.repository.ProductosRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductosServiceImpl implements ProductosService {
    private final ProductosRepository productosRepository;

    public ProductosServiceImpl(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    @Override
    public List<Productos> listar() {
        return productosRepository.findAll();
    }

    @Override
    public Productos buscarPorId(Integer id) {
        return productosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el producto No. " + id + "."));
    }

    @Override
    public Productos crear(Productos productos) {
        productos.setCodigoProducto(null);
        return productosRepository.save(productos);
    }

    @Override
    public Productos actualizar(Integer id, Productos productos) {
        Productos existente = buscarPorId(id);

        existente.setNombreProducto(productos.getNombreProducto());
        existente.setPrecio(productos.getPrecio());
        existente.setStock(productos.getStock());
        existente.setEstado(productos.getEstado());

        return productosRepository.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
        if (!productosRepository.existsById(id)) {
            throw new ResourceNotFoundException("No se encontró el producto No. " + id + ".");
        }
        productosRepository.deleteById(id);
    }
}
