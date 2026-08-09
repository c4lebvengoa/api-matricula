package com.unalm.matricula_api.dto;

public record CursoResponse(
        Long id, String codigo,
        String nombre,
        Integer creditos,
        Integer cupos
) {
}
