package com.example.backendmentoria.validators;

import com.example.backendmentoria.exceptions.IncorrectResourceRequestException;
import com.example.backendmentoria.models.Tema;

public class TemaValidator {

    public static void validate(Tema tema) {

        if (tema.getNombre() == null || tema.getNombre().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El nombre es requerido");
        }

        if (tema.getNombre().length() < 3) {
            throw new IncorrectResourceRequestException("El nombre debe ser mayor a 3 caracteres");
        }

        if (tema.getDescripcion() == null || tema.getDescripcion().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("La descripción es requerida");
        }

        if (tema.getDescripcion().length() < 3) {
            throw new IncorrectResourceRequestException("La descripción debe ser mayor a 3 caracteres");
        }

    }
}
