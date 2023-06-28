package com.example.backendmentoria.services;

import com.example.backendmentoria.models.Ocupacion;

import java.util.List;

public interface OcupacionService {

    public Ocupacion agregarOcupacion(Ocupacion ocupacion);

    public Ocupacion modificarOcupacion(Ocupacion ocupacion);

    public List<Ocupacion> listarOcupaciones();

    public void eliminarOcupacion(Long id);

    public Ocupacion obtenerOcupacionPorId(Long id);

}
