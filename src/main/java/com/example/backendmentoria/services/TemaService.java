package com.example.backendmentoria.services;

import com.example.backendmentoria.models.Tema;

import java.util.List;

public interface TemaService {

    public Tema agregarTema(Tema tema);

    public Tema modificarTema(Tema tema);

    public List<Tema> listarTemas();

    public void eliminarTema(Long id);

    public Tema obtenerTemaPorId(Long id);

}
