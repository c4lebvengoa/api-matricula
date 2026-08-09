package com.unalm.matricula_api.dto;

import com.unalm.matricula_api.entity.EstadoMatricula;

import java.time.LocalDateTime;
import java.util.List;

public record MatriculaResponse(
        Long id,
        Long estudianteId,
        LocalDateTime fecha,
        EstadoMatricula estado,
        List<Long> cursosIds
) {
}
