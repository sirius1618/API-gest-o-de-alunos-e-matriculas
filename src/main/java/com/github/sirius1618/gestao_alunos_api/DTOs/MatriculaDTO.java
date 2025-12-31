package com.github.sirius1618.gestao_alunos_api.DTOs;

import com.github.sirius1618.gestao_alunos_api.model.Aluno;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record matriculaDTO(
    Long id,

    @NotBlank(message = "É preciso ter o código da matricula")
    @Pattern(
            message = "Código da matrica é composto de 10 digitos numericos",
            regexp = "\\d{10}"
    )
    String codigoMatricula,

    @NotBlank(message = "É obrigatorio o nome do curso")
    @Size(min = 3, max = 100)
    String nomeCurso,

    @NotNull(message = "Data de inicio é obrigatorio")
    LocalDate dataInicio,

    @NotNull(message = "Data de inicio é obrigatorio")
    LocalDateTime dataAtualizacoa,

    Aluno aluno
) {
}
