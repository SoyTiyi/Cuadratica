package com.example.cuadratica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.cuadratica.service.CuadraticaService;

@RestController
@RequestMapping( "/cuadratica" )
public class CuadraticaController {

    private final CuadraticaService cuadraticaService;
    public CuadraticaController( @Autowired CuadraticaService cuadraticaService )
    {
        this.cuadraticaService = cuadraticaService;
    }

    @GetMapping
    public ResponseEntity<CuadraticaResponse> resultado(){
        return ResponseEntity.ok(cuadraticaService.resultado());
    }
}
