package com.github.sirius1618.gestao_alunos_api.service;

import com.github.sirius1618.gestao_alunos_api.DTOs.RequestCadastrarAlunoDTO;
import com.github.sirius1618.gestao_alunos_api.DTOs.ResponseMatriculaDTO;
import com.github.sirius1618.gestao_alunos_api.DTOs.ResponsetCadastrarAlunoDTO;
import com.github.sirius1618.gestao_alunos_api.model.Aluno;
import com.github.sirius1618.gestao_alunos_api.model.Matricula;
import com.github.sirius1618.gestao_alunos_api.repository.AlunoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Transactional
    public ResponsetCadastrarAlunoDTO salvar(RequestCadastrarAlunoDTO dados) {

        Aluno aluno = new Aluno();

        aluno.setNome(dados.nome());
        aluno.setTelefone(dados.telefone());
        aluno.setDataNascimento(dados.dataNascimento());

        /*
            `dados.matricula` é um DTO e não conseguimos salver um DTO no no banco de dados de forma direta, apenas classes de entidades conseguem fazer isso
             vamos fazer uma tranformação para cada elemento da nossa matricula (mDto) onde construimos um objeto entidade (m) e fazemos as operações usando ele.
             No fim vinculamos esse objeto ao nosso alubo e repetimos isso ate nossa estrutura acabar. Depois de passar por todos os elementos, tranformamos em
             uma lista e setamos essas matriculas ao nosso aluno.

         */
        var matriculas = dados.matriculas().stream().map(mDto ->{
            Matricula m = new Matricula();
            m.setCoidgoMatricula(mDto.codigoMatricula());
            m.setDataInicio(mDto.dataInicio());
            m.setNomeCurso(mDto.nomeCurso());
            m.setAluno(aluno);

            return m;
        }).toList();

        aluno.setMatriculas(matriculas);

        // contruimos um novo objeto alubo pois ao salvar sera gerado algumas variaveis (como o ID).
        Aluno alunoSalvo = alunoRepository.save(aluno);

        var matriculaResposnse = alunoSalvo.getMatriculas().stream().map(m -> {
            return new ResponseMatriculaDTO(
                m.getId(),
                m.getCoidgoMatricula(),
                m.getNomeCurso(),
                m.getDataInicio()
            );
        }).toList();

        return new ResponsetCadastrarAlunoDTO(
            alunoSalvo.getId(),
            alunoSalvo.getNome(),
            matriculaResposnse
        );
    }

    public List<ResponsetCadastrarAlunoDTO> listarAlunos() {
        List<Aluno> listaAluno = alunoRepository.findAll();

        return listaAluno.stream().map(aluno -> {

            var responseMatricula = aluno.getMatriculas().stream().map(matricula -> {
                return new ResponseMatriculaDTO(
                matricula.getId(),
                matricula.getCoidgoMatricula(),
                matricula.getNomeCurso(),
                matricula.getDataInicio()
                );
            }).toList();

            return new ResponsetCadastrarAlunoDTO(
                    aluno.getId(),
                    aluno.getNome(),
                    responseMatricula
            );
        }).toList();
    }
}
