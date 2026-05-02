package com.kevinmorales.ventas.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Usuarios", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username", "email"})
})
public class Usuarios {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_usuario")
    private Integer codigoUsuario;

    @NotBlank(message = "El nombre de usuario no puede estar vacío.")
    @Size(min = 3, max = 45, message = "El nombre de usuario debe contener entre 3 y 45 caracteres.")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "La contraseña no puede estar vacía.")
    @Size(min = 8, max = 60, message = "La contraseña debe contener entre 8 y 60 caracteres.")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "El correo no puede estar vacío.")
    @Size(min = 5, max = 60, message = "El correo debe contener entre 5 y 60 caracteres.")
    @Email(message = "No se ha ingresado un correo válido.")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "El rol de usuario no puede estar vacío.")
    @Size(min = 3, max = 45, message = "El rol de usuario debe contener entre 3 y 45 caracteres.")
    @Column(name = "rol")
    private String rol;

    @NotNull(message = "El estado no puede estar vacío.")
    @Column(name = "estado")
    private Boolean estado;

    public Integer getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Integer codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
