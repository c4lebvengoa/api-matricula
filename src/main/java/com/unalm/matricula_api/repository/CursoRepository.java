package com.unalm.matricula_api.repository;

import com.unalm.matricula_api.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Long> {
}
