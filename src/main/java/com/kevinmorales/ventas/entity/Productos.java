package com.kevinmorales.ventas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Productos {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_producto")
    private Integer codigoProducto;

    @NotBlank(message = "El nombre del producto no puede estar vacío.")
    @Size(min = 3, max = 60, message = "El nombre del producto debe contener entre 3 y 60 caracteres.")
    @Column(name = "nombre_producto")
    private String nombreProducto;

    @NotNull(message = "El precio no puede estar vacío.")
    @Min(value = 1, message = "El precio debe ser de al menos Q.1.00.")
    @Column(name = "precio")
    private Double precio;

    @NotNull(message = "El stock no puede estar vacío.")
    @Min(value = 1, message = "Debe existir al menos 1 stock disponible.")
    @Column(name = "stock")
    private Integer stock;

    @NotNull(message = "El estado no puede estar vacío.")
    @Column(name = "estado")
    private Boolean estado;

    public Integer getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
