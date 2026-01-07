package com.github.sirius1618.gestao_alunos_api.model;

import jakarta.persistence.*;
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

  @ManyToOne
  @JoinColumn(name = "aluno_id")
  private Aluno aluno;

    public void setCoidgoMatricula(String coidgoMatricula) {
        this.coidgoMatricula = coidgoMatricula;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Long getId() {
        return id;
    }

    public String getCoidgoMatricula() {
        return coidgoMatricula;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }
}
