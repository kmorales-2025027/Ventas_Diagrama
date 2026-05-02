package com.kevinmorales.ventas.controller;

import com.kevinmorales.ventas.entity.Ventas;
import com.kevinmorales.ventas.service.VentasService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/venta")
public class VentasController {
    private final VentasService ventasService;

    public VentasController(VentasService ventasService) {
        this.ventasService = ventasService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("ventas", ventasService.listar());
        return "venta";
    }

    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("venta", new Ventas());
        model.addAttribute("modoEdicion", false);
        return "venta-form";
    }

    @PostMapping("/guardar")
    public String crear(@Valid @ModelAttribute("venta") Ventas ventas, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("modoEdicion", false);
            return "venta-form";
        }
        ventasService.crear(ventas);
        return "redirect:/venta";
    }

    @GetMapping("/editar/{id}")
    public String formularioEdicion(@PathVariable @Min(value = 1, message = "El ID debe ser mayor o igual a 1.")
                                        Integer id, Model model) {
        Ventas venta = ventasService.buscarPorId(id);
        model.addAttribute("venta", venta);
        model.addAttribute("modoEdicion", true);
        return "venta-form";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable @Min(value = 1, message = "El ID debe ser mayor o igual a 1.") Integer id,
                             @Valid @ModelAttribute("venta") Ventas ventas, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("modoEdicion", true);
            return "venta-form";
        }
        ventasService.actualizar(id, ventas);
        return "redirect:/venta";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable @Min(value = 1, message = "El ID debe ser mayor o igual a 1.") Integer id) {
        ventasService.eliminar(id);
        return "redirect:/venta";
    }
}
