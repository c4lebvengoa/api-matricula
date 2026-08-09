package com.unalm.matricula_api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false,unique=true)
    private String codigo;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private Integer creditos;
    @Column(nullable = false)
    private Integer cupos;

}
