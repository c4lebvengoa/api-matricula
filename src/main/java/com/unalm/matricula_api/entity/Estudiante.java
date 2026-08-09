package com.unalm.matricula_api.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Estudiante {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false, unique=true)
    private String codigo;
    @Column(nullable = false)
    private String nombres;
    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false,unique = true)
    private String correo;

}
