package com.unalm.matricula_api.service;


import com.unalm.matricula_api.dto.MatriculaRequest;
import com.unalm.matricula_api.dto.MatriculaResponse;
import com.unalm.matricula_api.entity.*;
import com.unalm.matricula_api.mapper.MatriculaMapper;
import com.unalm.matricula_api.repository.CursoRepository;
import com.unalm.matricula_api.repository.EstudianteRepository;
import com.unalm.matricula_api.repository.MatriculaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final EstudianteRepository estudianteRepository;
    private final CursoRepository cursoRepository;
    private final MatriculaMapper mapper;

    public MatriculaService(
            MatriculaRepository matriculaRepository,
            EstudianteRepository estudianteRepository,
            CursoRepository cursoRepository,
            MatriculaMapper mapper) {

        this.matriculaRepository = matriculaRepository;
        this.estudianteRepository = estudianteRepository;
        this.cursoRepository = cursoRepository;
        this.mapper = mapper;
    }

    @Transactional
    public MatriculaResponse matricular(
            MatriculaRequest request) {

        Estudiante estudiante =
                estudianteRepository
                        .findById(request.estudianteId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Estudiante no encontrado"
                                ));

        List<Curso> cursos =
                cursoRepository.findAllById(
                        request.cursosIds()
                );
        System.out.println(
                "Hilo: " + Thread.currentThread().getName()
                        + " - Estudiante: "
                        + estudiante.getId()
                        + " - Cupos: "
                        + cursos.get(0).getCupos()
        );
        for (Curso curso : cursos) {

            if (curso.getCupos() <= 0) {

                throw new RuntimeException(
                        "No hay cupos para: "
                                + curso.getNombre()
                );
            }
        }

        Matricula matricula = new Matricula();

        matricula.setEstudiante(estudiante);
        matricula.setFecha(LocalDateTime.now());
        matricula.setEstado(EstadoMatricula.ACTIVA);

        List<DetalleMatricula> detalles =
                new ArrayList<>();

        for (Curso curso : cursos) {

            curso.setCupos(
                    curso.getCupos() - 1
            );

            DetalleMatricula detalle =
                    new DetalleMatricula();

            detalle.setMatricula(matricula);
            detalle.setCurso(curso);
            detalle.setCreditos(curso.getCreditos());

            detalles.add(detalle);
        }

        matricula.setDetalles(detalles);

        Matricula guardada =
                matriculaRepository.save(matricula);

        return mapper.toResponse(guardada);
    }
}