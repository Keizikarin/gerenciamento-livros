# Sistema de Gerenciamento de Livros

## Descrição

API REST desenvolvida em Java com Spring Boot para gerenciar uma biblioteca pessoal, permitindo cadastrar, consultar, listar, atualizar e excluir livros.

## Tecnologias utilizadas

- Java
- Spring Boot
- Spring Data JPA
- Maven
- Banco de dados H2
- JUnit 5
- Mockito
- Postman
- IntelliJ IDEA

## Funcionalidades

- Cadastrar livros
- Listar todos os livros
- Consultar livro por ID
- Atualizar informações de livros
- Excluir livros

## Estrutura do livro

Cada livro possui os seguintes campos:

- `id`
- `titulo`
- `autor`
- `genero`
- `anoPublicacao`
- `statusLeitura`

## Endpoints da API

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/livros` | Cadastrar livro |
| GET | `/livros` | Listar livros |
| GET | `/livros/{id}` | Consultar livro |
| PUT | `/livros/{id}` | Atualizar livro |
| DELETE | `/livros/{id}` | Excluir livro |

## Exemplo de cadastro

**POST** `/livros`

```json
{
  "titulo": "Dom Casmurro",
  "autor": "Machado de Assis",
  "genero": "Romance",
  "anoPublicacao": 1899,
  "statusLeitura": "Lido"
}
```

## Como executar

1. Clonar o repositório.
2. Abrir o projeto em uma IDE com suporte a Maven.
3. Aguardar o carregamento das dependências.
4. Executar a classe `GerenciamentoLivrosApplication`.
5. Acessar a API em `http://localhost:8080/livros`.

## Testes automatizados

Foram implementados cinco testes unitários para a camada de serviço utilizando JUnit 5 e Mockito.

**Resultado:** 5 testes executados e aprovados.

## Banco de dados

O projeto utiliza H2 com persistência local dos dados.