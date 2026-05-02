package com.kevinmorales.ventas.controller;

import com.kevinmorales.ventas.entity.Usuarios;
import com.kevinmorales.ventas.service.UsuariosService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private final UsuariosService usuariosService;

    public AuthController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/")
    public String redirectHome() {
        return "redirect:/home";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("usuario", new Usuarios());
        return "register";
    }

    @PostMapping("/register")
    public String registrar(@Valid @ModelAttribute("usuario") Usuarios usuarios, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";
        }
        try {
            usuariosService.registrar(usuarios);
            return "redirect:/login?registered";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }
}
