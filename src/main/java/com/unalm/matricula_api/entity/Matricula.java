package com.unalm.matricula_api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="estudiante_id",nullable = false)
    private Estudiante estudiante;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoMatricula estado;

    @OneToMany(
            mappedBy = "matricula",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<DetalleMatricula> detalles = new ArrayList<>();
}
