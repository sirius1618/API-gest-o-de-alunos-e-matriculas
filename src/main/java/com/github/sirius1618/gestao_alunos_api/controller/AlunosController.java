package com.github.sirius1618.gestao_alunos_api.controller;

import com.github.sirius1618.gestao_alunos_api.DTOs.RequestCadastrarAlunoDTO;
import com.github.sirius1618.gestao_alunos_api.DTOs.ResponsetCadastrarAlunoDTO;
import com.github.sirius1618.gestao_alunos_api.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunosController {

    private final AlunoService alunoService;

    public AlunosController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

  @PostMapping
  public ResponseEntity<ResponsetCadastrarAlunoDTO> cadastrarAluno(@RequestBody @Valid RequestCadastrarAlunoDTO dados) {
    var aluno = alunoService.salvar(dados);
    return ResponseEntity.status(HttpStatus.CREATED).body(aluno); // 201
  }

  @GetMapping
  public ResponseEntity<List<ResponsetCadastrarAlunoDTO>> listarTodosAlunos() {
    var listaAlunos = alunoService.listarAlunos();
    return ResponseEntity.status(HttpStatus.OK).body(listaAlunos);
  }
}
