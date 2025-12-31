package com.github.sirius1618.gestao_alunos_api.repository;

import com.github.sirius1618.gestao_alunos_api.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {}
