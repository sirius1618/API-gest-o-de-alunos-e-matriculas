package com.github.sirius1618.gestao_alunos_api.DTOs;

import java.util.List;

public record ResponsetCadastrarAlunoDTO(
        Long id,
        String nome,
        List<ResponseMatriculaDTO> matriculas
) { }
