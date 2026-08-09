package com.unalm.matricula_api.repository;

import com.unalm.matricula_api.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}