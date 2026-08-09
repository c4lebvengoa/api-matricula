package com.unalm.matricula_api.repository;
import com.unalm.matricula_api.entity.DetalleMatricula;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DetalleMatriculaRepository
        extends JpaRepository<DetalleMatricula, Long> {
}
