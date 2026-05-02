package com.kevinmorales.ventas.controller;

import com.kevinmorales.ventas.entity.Clientes;
import com.kevinmorales.ventas.service.ClientesService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cliente")
public class ClientesController {
    private final ClientesService clientesService;

    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clientes", clientesService.listar());
        return "cliente";
    }

    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("cliente", new Clientes());
        model.addAttribute("modoEdicion", false);
        return "cliente-form";
    }

    @PostMapping("/guardar")
    public String crear(@Valid @ModelAttribute("cliente") Clientes clientes, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("modoEdicion", false);
            return "cliente-form";
        }
        clientesService.crear(clientes);
        return "redirect:/cliente";
    }

    @GetMapping("/editar/{dpi}")
    public String formularioEdicion(@PathVariable @Min(value = 1, message = "El ID debe ser mayor o igual a 1.")
                                        Long dpi, Model model) {
        Clientes cliente = clientesService.buscarPorId(dpi);
        model.addAttribute("cliente", cliente);
        model.addAttribute("modoEdicion", true);
        return "cliente-form";
    }

    @PostMapping("/actualizar/{dpi}")
    public String actualizar(@PathVariable @Min(value = 1, message = "El ID debe ser mayor o igual a 1.") Long dpi,
                               @Valid @ModelAttribute("cliente") Clientes clientes, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("modoEdicion", true);
            return "cliente-form";
        }
        clientesService.actualizar(dpi, clientes);
        return "redirect:/cliente";
    }

    @GetMapping("/eliminar/{dpi}")
    public String eliminar(@PathVariable @Min(value = 1, message = "El DPI debe ser mayor o igual a 1.") Long dpi) {
        clientesService.eliminar(dpi);
        return "redirect:/cliente";
    }
}
