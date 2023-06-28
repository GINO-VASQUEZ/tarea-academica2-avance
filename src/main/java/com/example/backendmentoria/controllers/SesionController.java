package com.example.backendmentoria.controllers;

import com.example.backendmentoria.models.Sesion;
import com.example.backendmentoria.services.impl.SesionServiceImpl;
import com.example.backendmentoria.utils.WrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sesion")
@CrossOrigin(origins = "*")
public class SesionController {

    private final SesionServiceImpl sesionServiceImpl;

    public SesionController(SesionServiceImpl sesionServiceImpl) {
        this.sesionServiceImpl = sesionServiceImpl;
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<Sesion>> agregarSesion(@RequestBody Sesion sesion){
        Sesion newSesion = sesionServiceImpl.agregarSesion(sesion);
        return new WrapperResponse<>(true,"success",newSesion).createResponse();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WrapperResponse<Void>> eliminarSesion(@PathVariable("id") Long id){
        sesionServiceImpl.eliminarSesion(id);
        return new WrapperResponse<Void>(true, "success", null)
                .createResponse(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/listar")
    public List<Sesion> listarReservas(){
        return sesionServiceImpl.listarSesion();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<WrapperResponse<Sesion>> obtenerSesionPorId(@PathVariable("id") Long id){
        Sesion sesion = sesionServiceImpl.obtenerSesionPorId(id);
        return new WrapperResponse<>(true, "success", sesion).createResponse(HttpStatus.OK);
    }

}
