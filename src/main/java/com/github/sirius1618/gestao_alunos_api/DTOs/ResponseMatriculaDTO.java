package com.github.sirius1618.gestao_alunos_api.DTOs;

import java.time.LocalDate;

public record ResponseMatriculaDTO(
    Long id,
    String codigoMatricula,
    String nomeCurso,
    LocalDate dataInicio
) {
}
