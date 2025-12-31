package com.github.sirius1618.gestao_alunos_api.DTOs;

import com.github.sirius1618.gestao_alunos_api.model.Matricula;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

public record CadastrarAlunoDTO(
    @NotBlank(message = "O nome é obrigatorio")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 a 100 caracteres")
    String nome,

    @NotBlank(message = "O telefone é obrigatorio")
    @Pattern(regexp = "\\d{10,11}", message = "O telefone deve conter apenas números (10 ou 11 dígitos)")
    String telefone,

    @NotNull(message = "A data de nasicemento é obrigatorio")
    @Past(message = "A data de nascimento deve ser no passado")
    LocalDate dataNascimento,

    @Valid
    @NotEmpty(message = "O aluno deve ter pelo menos uma matricula")
    List<MatriculaDTO>
    matriculas) {}
