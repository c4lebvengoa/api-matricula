package com.unalm.matricula_api.mapper;

import com.unalm.matricula_api.dto.MatriculaResponse;
import com.unalm.matricula_api.entity.Matricula;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MatriculaMapper {

    public MatriculaResponse toResponse(
            Matricula matricula) {

        List<Long> cursosIds =
                matricula.getDetalles()
                        .stream()
                        .map(detalle ->
                                detalle.getCurso().getId())
                        .toList();

        return new MatriculaResponse(
                matricula.getId(),
                matricula.getEstudiante().getId(),
                matricula.getFecha(),
                matricula.getEstado(),
                cursosIds
        );
    }
}