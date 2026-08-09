package com.unalm.matricula_api.controller;


import com.unalm.matricula_api.dto.MatriculaRequest;
import com.unalm.matricula_api.dto.MatriculaResponse;
import com.unalm.matricula_api.service.MatriculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    private final MatriculaService service;

    public MatriculaController(
            MatriculaService service) {

        this.service = service;
    }

    @PostMapping
    public ResponseEntity<MatriculaResponse> matricular(
            @RequestBody MatriculaRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.matricular(request));
    }
}
