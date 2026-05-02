package com.kevinmorales.ventas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Clientes {
    @Id
    @NotNull(message = "El DPI del cliente no puede estar vacío.")
    @Column(name = "dpi_cliente")
    private Long dpiCliente;

    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(min = 2, max = 50, message = "El nombre debe contener entre 2 y 50 caracteres.")
    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @NotBlank(message = "El apellido no puede estar vacío.")
    @Size(min = 2, max = 50, message = "El apellido debe contener entre 2 y 50 caracteres.")
    @Column(name = "apellido_cliente")
    private String apellidoCliente;

    @NotBlank(message = "La dirección no puede estar vacía.")
    @Size(min = 6, max = 100, message = "La dirección debe contener entre 6 y 100 caracteres.")
    @Column(name = "direccion")
    private String direccion;

    @NotNull(message = "El estado no puede estar vacío.")
    @Column(name = "estado")
    private Boolean estado;

    public Long getDpiCliente() {
        return dpiCliente;
    }

    public void setDpiCliente(Long dpiCliente) {
        this.dpiCliente = dpiCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
