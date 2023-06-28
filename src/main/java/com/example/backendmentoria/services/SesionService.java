package com.example.backendmentoria.services;

import com.example.backendmentoria.models.Sesion;

import java.util.List;

public interface SesionService {

    public Sesion agregarSesion(Sesion sesion);

    public List<Sesion> listarSesion();

    public void eliminarSesion(Long id);

    public Sesion obtenerSesionPorId(Long id);

}
