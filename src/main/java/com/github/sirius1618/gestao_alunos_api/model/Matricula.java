package com.github.sirius1618.gestao_alunos_api.model;

import jakarta.persistence.*;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_matricula")
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String coidgoMatricula;
    private String nomeCurso;
    private LocalDate dataInicio;

    @Column(updatable = false)
    private LocalDateTime dataInclusao;
    private LocalDateTime dataAtualizacao;

    @ManyToOne // muitas matriculas para um aluno
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
}
