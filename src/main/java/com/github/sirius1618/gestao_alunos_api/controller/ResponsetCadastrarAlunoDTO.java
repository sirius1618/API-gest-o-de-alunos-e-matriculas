package com.github.sirius1618.gestao_alunos_api.controller;

import com.github.sirius1618.gestao_alunos_api.model.Matricula;

import java.util.List;

public record ResponsetCadastrarAlunoDTO(
        Long id,
        String nome,
        List<Matricula> matriculas
) { }
