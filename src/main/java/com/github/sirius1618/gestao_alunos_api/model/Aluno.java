package com.github.sirius1618.gestao_alunos_api.model;

import com.github.sirius1618.gestao_alunos_api.DTOs.RequestMatriculaDTO;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_aluno")
public class Aluno {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 150)
  private String nome;

  @Column(length = 20)
  private String telefone;

  private LocalDate dataNascimento;

  @Column(updatable = false)
  private LocalDateTime dataInclusao;

  private LocalDateTime dataAtualizacao;

  @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Matricula> matriculas;

  @PrePersist
  protected void inicializarData() {
    this.dataInclusao = LocalDateTime.now();
    this.dataAtualizacao = LocalDateTime.now();
  }

  @PreUpdate
  protected void atualizandoData() {
    this.dataAtualizacao = LocalDateTime.now();
  }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setTelefone(String telefone) {
      this.telefone = telefone;
  }

  public void setNome(String nome) {
        this.nome = nome;
  }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }
}
