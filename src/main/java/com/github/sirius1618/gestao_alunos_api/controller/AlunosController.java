package com.github.sirius1618.gestao_alunos_api.controller;

import com.github.sirius1618.gestao_alunos_api.DTOs.CadastrarAlunoDTO;
import com.github.sirius1618.gestao_alunos_api.model.Aluno;
import com.github.sirius1618.gestao_alunos_api.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
public class AlunosController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

  @PostMapping
  public ResponseEntity<ResponsetCadastrarAlunoDTO> cadastrarAluno(@RequestBody @Valid  CadastrarAlunoDTO dados) {
//        TODO: ver se precisa alterar e por que precisa alterar
    var aluno = alunoService.salvar(dados);
    return ResponseEntity.status(HttpStatus.CREATED).body(aluno); // 201
  }
}
