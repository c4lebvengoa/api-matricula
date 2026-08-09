package com.unalm.matricula_api.repository;

import com.unalm.matricula_api.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}