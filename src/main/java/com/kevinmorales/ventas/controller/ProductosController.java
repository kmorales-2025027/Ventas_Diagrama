package com.kevinmorales.ventas.controller;

import com.kevinmorales.ventas.entity.Productos;
import com.kevinmorales.ventas.service.ProductosService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/producto")
public class ProductosController {
    private final ProductosService productosService;

    public ProductosController(ProductosService productosService) {
        this.productosService = productosService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("productos", productosService.listar());
        return "producto";
    }

    @GetMapping("/nuevo")
    public String formularioNuevo(Model model) {
        model.addAttribute("producto", new Productos());
        model.addAttribute("modoEdicion", false);
        return "producto-form";
    }

    @PostMapping("/guardar")
    public String crear(@Valid @ModelAttribute("producto") Productos productos, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("modoEdicion", false);
            return "producto-form";
        }
        productosService.crear(productos);
        return "redirect:/producto";
    }

    @GetMapping("/editar/{id}")
    public String formularioEdicion(@PathVariable @Min(value = 1, message = "El ID debe ser mayor o igual a 1.")
                                        Integer id, Model model) {
        Productos producto = productosService.buscarPorId(id);
        model.addAttribute("producto", producto);
        model.addAttribute("modoEdicion", true);
        return "producto-form";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable @Min(value = 1, message = "El ID debe ser mayor o igual a 1.") Integer id,
                             @Valid @ModelAttribute("producto") Productos productos, BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            model.addAttribute("modoEdicion", true);
            return "producto-form";
        }
        productosService.actualizar(id, productos);
        return "redirect:/producto";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable @Min(value = 1, message = "El ID debe ser mayor o igual a 1.") Integer id) {
        productosService.eliminar(id);
        return "redirect:/producto";
    }
}
