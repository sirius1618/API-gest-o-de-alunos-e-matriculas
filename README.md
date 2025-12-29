# 📚 API de Gestão de Alunos e Matrículas

Este projeto consiste em uma **API REST** desenvolvida com **Java e Spring Boot** para o gerenciamento de **alunos** e suas **matrículas em cursos educacionais**, conforme o diagrama de classes proposto no desafio.

O objetivo é demonstrar conhecimentos básicos de backend, modelagem de dados, API RESTful, JPA/Hibernate e boas práticas de desenvolvimento.

---

## 🧩 Diagrama de Classes

* **Aluno** possui uma relação **1:N** com **Matrícula**
* Um aluno pode ter **várias matrículas**
* Cada matrícula pertence a **um único aluno**

### Aluno

* id
* nome
* telefone
* dataNascimento
* dataInclusao
* dataAtualizacao

### Matrícula

* id
* codigoMatricula
* nomeCurso
* dataInicio
* dataInclusao
* dataAtualizacao

---

## 🎯 Funcionalidades da API

A API permite:

* ✅ Cadastrar um aluno junto com suas matrículas
* ✅ Listar todos os alunos cadastrados
* ✅ Listar todas as matrículas de um aluno a partir do seu ID
* ✅ Atualizar os dados de um aluno (e suas matrículas)
* ✅ Remover um aluno (e todas as matrículas associadas)

---

## 🛠️ Tecnologias Utilizadas

* **Java 17**
* **Spring Boot 3+**
* **Spring Data JPA**
* **H2 Database** (banco de dados em memória)
* **Maven**
* **REST Client (.http)** para testes rápidos

---

## 🏗️ Estrutura do Projeto (sugestão)

```
├── controller
│   ├── AlunoController.java
│
├── service
│   ├── AlunoService.java
│
├── repository
│   ├── AlunoRepository.java
│   ├── MatriculaRepository.java
│
├── model
│   ├── Aluno.java
│   ├── Matricula.java
│
├── dto
│   ├── AlunoRequestDTO.java
│   ├── AlunoResponseDTO.java
│   ├── MatriculaDTO.java
│
└── Application.java
```

---

## 🔗 Endpoints da API (exemplo)

### ➕ Cadastrar aluno com matrículas

`POST /alunos`

```json
{
  "nome": "João Silva",
  "telefone": "(11) 99999-9999",
  "dataNascimento": "2000-05-10",
  "matriculas": [
    {
      "codigoMatricula": "MAT-001",
      "nomeCurso": "Engenharia de Software",
      "dataInicio": "2024-01-01"
    }
  ]
}
```

---

### 📄 Listar todos os alunos

`GET /alunos`

---

### 📘 Listar matrículas de um aluno

`GET /alunos/{id}/matriculas`

---

### ✏️ Atualizar aluno

`PUT /alunos/{id}`

---

### 🗑️ Remover aluno

`DELETE /alunos/{id}`

> Ao remover um aluno, todas as matrículas associadas são removidas automaticamente.

---

## 🧪 Banco H2

* Console disponível em:

  ```
  http://localhost:8080/h2-console
  ```
* JDBC URL padrão:

  ```
  jdbc:h2:mem:testdb
  ```

---

## ▶️ Como Executar o Projeto

1. Clone o repositório
2. Acesse a pasta do projeto
3. Execute:

```bash
mvn spring-boot:run
```

4. A API estará disponível em:

```
http://localhost:8080
```

---

## 📌 Observações

* O projeto utiliza **relacionamento JPA com cascade**, garantindo integridade entre aluno e matrículas
* Datas de inclusão e atualização podem ser preenchidas automaticamente com `@PrePersist` e `@PreUpdate`
* Ideal para fins de estudo, desafios técnicos e portfólio

---

## 🚀 Possíveis Melhorias

* Implementar validações com Bean Validation
* Adicionar paginação
* Criar testes unitários
* Implementar autenticação (Spring Security)
* Migrar para banco PostgreSQL/MySQL

---

## 👨‍💻 Autor

Projeto desenvolvido como **desafio para vaga júnior**, com foco em boas práticas e fundamentos de backend com Java e Spring Boot.
