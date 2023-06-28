package com.example.backendmentoria.services.impl;

import com.example.backendmentoria.exceptions.ResourceNotFoundException;
import com.example.backendmentoria.models.Sesion;
import com.example.backendmentoria.repositories.SesionRepository;
import com.example.backendmentoria.repositories.TemaRepository;
import com.example.backendmentoria.services.SesionService;
import com.example.backendmentoria.validators.SesionValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SesionServiceImpl implements SesionService {

    private final SesionRepository sesionRepository;

    public SesionServiceImpl(SesionRepository sesionRepository) {
        this.sesionRepository = sesionRepository;
    }

    @Transactional
    public Sesion agregarSesion(Sesion sesion){
        SesionValidator.validate(sesion);
        sesion.getItems().forEach(line->line.setSesion(sesion));
        return sesionRepository.save(sesion);
    }

    @Transactional(readOnly = true)
    public List<Sesion> listarSesion(){
        return sesionRepository.findAll();
    }

    @Transactional
    public void eliminarSesion(Long id){
        Sesion sesion = this.obtenerSesionPorId(id);
        sesionRepository.delete(sesion);
    }

    public Sesion obtenerSesionPorId(Long id){
        Optional<Sesion> nota = sesionRepository.findById(id);
        return nota.orElseThrow(() -> new ResourceNotFoundException("Sesion no found"));
    }

}
