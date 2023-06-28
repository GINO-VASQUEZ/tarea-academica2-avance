package com.example.backendmentoria.validators;

import com.example.backendmentoria.exceptions.IncorrectResourceRequestException;
import com.example.backendmentoria.models.Ocupacion;

public class OcupacionValidator {

    public static void validate(Ocupacion ocupacion) {

        if (ocupacion.getTitulo() == null || ocupacion.getTitulo().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("El titulo es requerido");
        }

        if (ocupacion.getTitulo().length() < 3) {
            throw new IncorrectResourceRequestException("El titulo debe ser mayor a 3 caracteres");
        }

        if (ocupacion.getDescripcion() == null || ocupacion.getDescripcion().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("La descripción es requerida");
        }

        if (ocupacion.getDescripcion().length() < 3) {
            throw new IncorrectResourceRequestException("La descripción debe ser mayor a 3 caracteres");
        }

        if (ocupacion.getOcupacion() == null || ocupacion.getOcupacion().trim().isEmpty()) {
            throw new IncorrectResourceRequestException("La ocupacion es requerida");
        }

        if (ocupacion.getOcupacion().length() < 3) {
            throw new IncorrectResourceRequestException("La ocupacion debe ser mayor a 3 caracteres");
        }

    }

}
