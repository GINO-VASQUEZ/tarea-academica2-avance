package com.example.backendmentoria.controllers;

import com.example.backendmentoria.models.Ocupacion;
import com.example.backendmentoria.services.impl.OcupacionServiceImpl;
import com.example.backendmentoria.utils.WrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ocupacion")
@CrossOrigin(origins = "*")
public class OcupacionController {

    private final OcupacionServiceImpl ocupacionService;

    public OcupacionController(OcupacionServiceImpl ocupacionService) {
        this.ocupacionService = ocupacionService;
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<Ocupacion>> agregarOcupacion(@RequestBody Ocupacion ocupacion){
        Ocupacion newOcupacion = ocupacionService.agregarOcupacion(ocupacion);
        return new WrapperResponse<>(true,"success",newOcupacion).createResponse();
    }

    @PutMapping
    public ResponseEntity<WrapperResponse<Ocupacion>> modificarOcupacion(@RequestBody Ocupacion ocupacion){
        Ocupacion ocupacionActualizado = ocupacionService.modificarOcupacion(ocupacion);
        return new WrapperResponse<Ocupacion>(true, "success", ocupacionActualizado)
                .createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WrapperResponse<Void>> eliminarOcupacion(@PathVariable("id") Long id){
        ocupacionService.eliminarOcupacion(id);
        return new WrapperResponse<Void>(true, "success", null)
                .createResponse(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/listar")
    public List<Ocupacion> listarReservas(){
        return ocupacionService.listarOcupaciones();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<WrapperResponse<Ocupacion>> obtenerOcupacionPorId(@PathVariable("id") Long id){
        Ocupacion ocupacion = ocupacionService.obtenerOcupacionPorId(id);
        return new WrapperResponse<>(true, "success", ocupacion).createResponse(HttpStatus.OK);
    }

}
