package com.example.backendmentoria.services.impl;

import com.example.backendmentoria.exceptions.GeneralServiceException;
import com.example.backendmentoria.exceptions.IncorrectResourceRequestException;
import com.example.backendmentoria.exceptions.ResourceNotFoundException;
import com.example.backendmentoria.models.Tema;
import com.example.backendmentoria.repositories.TemaRepository;
import com.example.backendmentoria.services.TemaService;
import com.example.backendmentoria.validators.TemaValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TemaServiceImpl implements TemaService {

    private final TemaRepository temaRepository;

    public TemaServiceImpl(TemaRepository temaRepository) {
        this.temaRepository = temaRepository;
    }

    @Transactional
    public Tema agregarTema(Tema tema) {
        try {
            TemaValidator.validate(tema);
            return temaRepository.save(tema);
        }catch (IncorrectResourceRequestException | ResourceNotFoundException e){
            throw e;
        }catch (Exception e){
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Transactional
    public Tema modificarTema(Tema tema) {
        TemaValidator.validate(tema);

        Tema temaActualizado = temaRepository.findById(tema.getId()).orElseThrow(() -> new ResourceNotFoundException("no existe el tema"));

        temaActualizado.setNombre(tema.getNombre());
        temaActualizado.setDescripcion(tema.getDescripcion());

        return temaRepository.save(temaActualizado);
    }

    @Transactional(readOnly = true)
    public List<Tema> listarTemas() {
        return temaRepository.findAll();
    }

    @Transactional
    public void eliminarTema(Long id) {
        temaRepository.deleteById(id);
    }

    public Tema obtenerTemaPorId(Long id) {
        Optional<Tema> tema = temaRepository.findById(id);
        return tema.orElseThrow(() -> new ResourceNotFoundException("Tema no found"));
    }
}
