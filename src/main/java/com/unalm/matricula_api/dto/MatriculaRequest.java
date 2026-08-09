package com.unalm.matricula_api.dto;

import java.util.List;

public record MatriculaRequest(
        Long estudianteId,
        List<Long> cursosIds
) {
}
