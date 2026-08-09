package com.unalm.matricula_api.controller;

import com.unalm.matricula_api.dto.CursoRequest;
import com.unalm.matricula_api.dto.CursoResponse;
import com.unalm.matricula_api.service.CursoService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService=cursoService;
    }
    @PostMapping
    public ResponseEntity<CursoResponse> crear(@RequestBody CursoRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.crear(request));
    }
    @GetMapping
    public ResponseEntity<List<CursoResponse>> listar(){
        return ResponseEntity.ok(cursoService.listar());
    }
}
