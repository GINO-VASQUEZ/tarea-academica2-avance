package com.example.backendmentoria.controllers;

import com.example.backendmentoria.models.Tema;
import com.example.backendmentoria.services.impl.TemaServiceImpl;
import com.example.backendmentoria.utils.WrapperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tema")
@CrossOrigin(origins = "*")
public class TemaController {

    private final TemaServiceImpl temaService;

    public TemaController(TemaServiceImpl temaService) {
        this.temaService = temaService;
    }

    @PostMapping
    public ResponseEntity<WrapperResponse<Tema>> agregarTema(@RequestBody Tema tema){
        Tema newTema = temaService.agregarTema(tema);
        return new WrapperResponse<>(true,"success",newTema).createResponse();
    }

    @PutMapping
    public ResponseEntity<WrapperResponse<Tema>> modificarTema(@RequestBody Tema tema){
        Tema temaActualizado = temaService.modificarTema(tema);
        return new WrapperResponse<Tema>(true, "success", temaActualizado)
                .createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WrapperResponse<Void>> eliminarTema(@PathVariable("id") Long id){
        temaService.eliminarTema(id);
        return new WrapperResponse<Void>(true, "success", null)
                .createResponse(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/listar")
    public List<Tema> listarReservas(){
        return temaService.listarTemas();
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<WrapperResponse<Tema>> obtenerTemaPorId(@PathVariable("id") Long id){
        Tema tema = temaService.obtenerTemaPorId(id);
        return new WrapperResponse<>(true, "success", tema).createResponse(HttpStatus.OK);
    }

}
