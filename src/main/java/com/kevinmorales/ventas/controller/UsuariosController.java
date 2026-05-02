package com.kevinmorales.ventas.controller;

import com.kevinmorales.ventas.entity.Usuarios;
import com.kevinmorales.ventas.service.UsuariosService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuario")
public class UsuariosController {
    private final UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuarios", usuariosService.listar());
        return "usuario";
    }

    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("usuario", new Usuarios());
        model.addAttribute("modoEdicion", false);
        return "usuario-form";
    }

    @PostMapping("/guardar")
    public String crear(@Valid @ModelAttribute("usuario") Usuarios usuarios, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("modoEdicion", false);
            return "usuario-form";
        }
        usuariosService.crear(usuarios);
        return "redirect:/usuario";
    }

    @GetMapping("/editar/{id}")
    public String formularioEdicion(@PathVariable @Min(value = 1, message = "El ID debe ser mayor o igual a 1.")
                                        Integer id, Model model) {
        Usuarios usuario = usuariosService.buscarPorId(id);
        model.addAttribute("usuario", usuario);
        model.addAttribute("modoEdicion", true);
        return "usuario-form";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable @Min(value = 1, message = "El ID debe ser mayor o igual a 1.") Integer id,
                               @Valid @ModelAttribute("usuario") Usuarios usuarios, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("modoEdicion", true);
            return "usuario-form";
        }
        usuariosService.actualizar(id, usuarios);
        return "redirect:/usuario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable @Min(value = 1, message = "El ID debe ser mayor o igual a 1.") Integer id) {
        usuariosService.eliminar(id);
        return "redirect:/usuario";
    }
}
