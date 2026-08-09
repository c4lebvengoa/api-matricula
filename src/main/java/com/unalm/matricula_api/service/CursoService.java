package com.unalm.matricula_api.service;
import com.unalm.matricula_api.dto.CursoRequest;
import com.unalm.matricula_api.dto.CursoResponse;
import com.unalm.matricula_api.entity.Curso;
import com.unalm.matricula_api.mapper.CursoMapper;
import com.unalm.matricula_api.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;
    private final CursoMapper cursoMapper;

    public CursoService(CursoRepository cursoRepository,
                        CursoMapper cursoMapper){
        this.cursoRepository=cursoRepository;
        this.cursoMapper=cursoMapper;
    }
    public CursoResponse crear(CursoRequest request){
        Curso curso=cursoMapper.toEntity(request);
        Curso guardado=cursoRepository.save(curso);
        return cursoMapper.toResponse(guardado);
    }
    public List<CursoResponse> listar(){
        return cursoRepository.findAll().stream().map(cursoMapper::toResponse).toList();
    }

}
