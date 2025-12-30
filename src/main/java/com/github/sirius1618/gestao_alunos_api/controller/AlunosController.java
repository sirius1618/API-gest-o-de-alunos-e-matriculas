package com.github.sirius1618.gestao_alunos_api.controller;

import com.github.sirius1618.gestao_alunos_api.model.Aluno;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/getao-alunos")
public class AlunosController {
    @PostMapping("/cadastrar-alunos")
    public void cadastrarAluno(@ResponseBody Aluno aluno) {


    }
}
