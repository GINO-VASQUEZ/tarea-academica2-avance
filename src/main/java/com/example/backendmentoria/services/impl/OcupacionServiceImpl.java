package com.example.backendmentoria.services.impl;

import com.example.backendmentoria.exceptions.GeneralServiceException;
import com.example.backendmentoria.exceptions.IncorrectResourceRequestException;
import com.example.backendmentoria.exceptions.ResourceNotFoundException;
import com.example.backendmentoria.models.Ocupacion;
import com.example.backendmentoria.repositories.OcupacionRepository;
import com.example.backendmentoria.services.OcupacionService;
import com.example.backendmentoria.validators.OcupacionValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OcupacionServiceImpl implements OcupacionService {

    private final OcupacionRepository ocupacionRepository;

    public OcupacionServiceImpl(OcupacionRepository ocupacionRepository) {
        this.ocupacionRepository = ocupacionRepository;
    }

    @Override
    public Ocupacion agregarOcupacion(Ocupacion ocupacion) {
        try {
            OcupacionValidator.validate(ocupacion);
            return ocupacionRepository.save(ocupacion);
        }catch (IncorrectResourceRequestException | ResourceNotFoundException e){
            throw e;
        }catch (Exception e){
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Ocupacion modificarOcupacion(Ocupacion ocupacion) {
        OcupacionValidator.validate(ocupacion);

        Ocupacion ocupacionActualizada = ocupacionRepository.findById(ocupacion.getId()).orElseThrow(() -> new ResourceNotFoundException("no existe la ocupacion"));

        ocupacionActualizada.setTitulo(ocupacion.getTitulo());
        ocupacionActualizada.setDescripcion(ocupacion.getDescripcion());
        ocupacionActualizada.setOcupacion(ocupacion.getOcupacion());

        return ocupacionRepository.save(ocupacionActualizada);
    }

    @Transactional(readOnly = true)
    public List<Ocupacion> listarOcupaciones() {
        return ocupacionRepository.findAll();
    }

    @Transactional
    public void eliminarOcupacion(Long id) {
        ocupacionRepository.deleteById(id);
    }

    @Override
    public Ocupacion obtenerOcupacionPorId(Long id) {
        Optional<Ocupacion> nota = ocupacionRepository.findById(id);
        return nota.orElseThrow(() -> new ResourceNotFoundException("Ocupacion no found"));
    }

}
