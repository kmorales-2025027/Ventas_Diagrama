package com.kevinmorales.ventas.controller;

import com.kevinmorales.ventas.entity.DetalleVenta;
import com.kevinmorales.ventas.service.DetalleVentaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/detalle")
public class DetalleVentaController {
    private final DetalleVentaService detalleVentaService;

    public DetalleVentaController(DetalleVentaService detalleVentaService) {
        this.detalleVentaService = detalleVentaService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("detalles", detalleVentaService.listar());
        return "detalle";
    }

    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("detalle", new DetalleVenta());
        model.addAttribute("modoEdicion", false);
        return "detalle-form";
    }

    @PostMapping("/guardar")
    public String crear(@Valid @ModelAttribute("detalle") DetalleVenta detalleVenta, BindingResult result,
                        Model model) {
        if (result.hasErrors()) {
            model.addAttribute("modoEdicion", false);
            return "detalle-form";
        }
        detalleVentaService.crear(detalleVenta);
        return "redirect:/detalle";
    }

    @GetMapping("/editar/{id}")
    public String formularioEdicion(@PathVariable @Min(value = 1, message = "El ID debe ser mayor o igual a 1.")
                                        Integer id, Model model) {
        DetalleVenta detalle = detalleVentaService.buscarPorId(id);
        model.addAttribute("detalle", detalle);
        model.addAttribute("modoEdicion", true);
        return "detalle-form";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable @Min(value = 1, message = "El ID debe ser mayor o igual a 1.") Integer id,
                             @Valid @ModelAttribute("detalle") DetalleVenta detalleVenta, BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            model.addAttribute("modoEdicion", true);
            return "detalle-form";
        }
        detalleVentaService.actualizar(id, detalleVenta);
        return "redirect:/detalle";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        detalleVentaService.eliminar(id);
        return "redirect:/detalle";
    }
}
