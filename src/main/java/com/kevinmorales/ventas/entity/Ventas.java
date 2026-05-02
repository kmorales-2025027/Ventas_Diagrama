package com.kevinmorales.ventas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.sql.Date;

@Entity
public class Ventas {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_Venta")
    private Integer codigoVenta;

    @NotNull(message = "La fecha de la venta no puede estar vacía.")
    @PastOrPresent(message = "La fecha de la venta no puede ser posterior a la actual.")
    @Column(name = "fecha_venta")
    private Date fechaVenta;

    @NotNull(message = "El total no puede estar vacío.")
    @Min(value = 1, message = "El total debe ser de al menos Q.1.00.")
    @Column(name = "total")
    private Double total;

    @NotNull(message = "El estado no puede estar vacío.")
    @Column(name = "estado")
    private Boolean estado;

    @NotNull(message = "El DPI del cliente no puede estar vacío.")
    @Min(value = 1, message = "El DPI del cliente no puede ser negativo.")
    @Column(name = "Clientes_dpi_cliente")
    private Long clientesDpiCliente;

    @NotNull(message = "El código del usuario no puede estar vacío.")
    @Min(value = 1, message = "El código del usuario no puede ser negativo.")
    @Column(name = "Usuarios_codigo_usuario")
    private Integer usuariosCodigoUsuario;

    public Integer getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(Integer codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Long getClientesDpiCliente() {
        return clientesDpiCliente;
    }

    public void setClientesDpiCliente(Long clientesDpiCliente) {
        this.clientesDpiCliente = clientesDpiCliente;
    }

    public Integer getUsuariosCodigoUsuario() {
        return usuariosCodigoUsuario;
    }

    public void setUsuariosCodigoUsuario(Integer usuariosCodigoUsuario) {
        this.usuariosCodigoUsuario = usuariosCodigoUsuario;
    }
}
