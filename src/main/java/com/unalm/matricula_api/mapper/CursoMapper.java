package com.unalm.matricula_api.mapper;

import com.unalm.matricula_api.dto.CursoRequest;
import com.unalm.matricula_api.dto.CursoResponse;
import com.unalm.matricula_api.entity.Curso;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {
    public Curso toEntity(CursoRequest request){
       Curso curso=new Curso();
        curso.setCodigo(request.codigo());
        curso.setNombre(request.nombre());
        curso.setCreditos(request.creditos());
        curso.setCodigo(request.codigo());
        curso.setCupos(request.cupos());
        return curso;
    }
    public CursoResponse toResponse(Curso curso){
        return new CursoResponse(
                curso.getId(),
                curso.getCodigo(),
                curso.getNombre(),
                curso.getCreditos(),
                curso.getCupos()
        );
    }
}
