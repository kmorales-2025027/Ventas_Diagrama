package com.kevinmorales.ventas.exception;

import java.nio.file.AccessDeniedException;
import java.util.List;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleValidation(ResourceNotFoundException ex, Model model){
        model.addAttribute("message", ex.getMessage());
        return "error";
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleValidation(ConstraintViolationException ex, Model model){
        String msg = ex.getConstraintViolations()
                .iterator()
                .next()
                .getMessage();
        model.addAttribute("message", msg);
        return "error";
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleBadJson(HttpMessageNotReadableException ex, Model model) {
        model.addAttribute("message", "JSON inválido o tipo de dato incorrecto.");
        return "error";
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleBodyValidation(MethodArgumentNotValidException ex, Model model) {
        List<String> mensajes = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getDefaultMessage())
                .toList();

        model.addAttribute("errors", mensajes);
        return "error";
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleValidation(DataIntegrityViolationException ex, Model model) {
        model.addAttribute("message", "La llave foránea no existe.");
        return "error";
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleValidation(MethodArgumentTypeMismatchException ex, Model model) {
        model.addAttribute("message", "El tipo de dato en la ruta es inválido.");
        return "error";
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound(NoHandlerFoundException ex, Model model) {
        model.addAttribute("message", "URL no encontrada.");
        return "error";
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String accessDenied(AccessDeniedException ex, Model model) {
        model.addAttribute("message", "Se requiere un rol de ADMIN para continuar.");
        return "error";
    }
}
