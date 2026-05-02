package com.kevinmorales.ventas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class DetalleVenta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_detalle_venta")
    private Integer codigoDetalleVenta;

    @NotNull(message = "La cantidad no puede estar vacía.")
    @Min(value = 1, message = "Se debe incluir al menos un producto.")
    @Column(name = "cantidad")
    private Integer cantidad;

    @NotNull(message = "El precio unitario no puede estar vacío.")
    @Min(value = 1, message = "El precio unitario debe ser de al menos Q.1.00.")
    @Column(name = "precio_unitario")
    private Double precioUnitario;

    @NotNull(message = "El subtotal no puede estar vacío.")
    @Min(value = 1, message = "El subtotal debe ser de al menos Q.1.00.")
    @Column(name = "subtotal")
    private Double subtotal;

    @NotNull(message = "El código del producto no puede estar vacío.")
    @Min(value = 1, message = "El código del producto no puede ser negativo.")
    @Column(name = "Productos_codigo_producto")
    private Integer productosCodigoProducto;

    @NotNull(message = "El código de la venta no puede estar vacío.")
    @Min(value = 1, message = "El código de la venta no puede ser negativo.")
    @Column(name = "Ventas_codigo_venta")
    private Integer ventasCodigoVenta;

    public Integer getCodigoDetalleVenta() {
        return codigoDetalleVenta;
    }

    public void setCodigoDetalleVenta(Integer codigoDetalleVenta) {
        this.codigoDetalleVenta = codigoDetalleVenta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getProductosCodigoProducto() {
        return productosCodigoProducto;
    }

    public void setProductosCodigoProducto(Integer productosCodigoProducto) {
        this.productosCodigoProducto = productosCodigoProducto;
    }

    public Integer getVentasCodigoVenta() {
        return ventasCodigoVenta;
    }

    public void setVentasCodigoVenta(Integer ventasCodigoVenta) {
        this.ventasCodigoVenta = ventasCodigoVenta;
    }
}
