# ServeRest API Automation

![Build Status](https://github.com/Artenize/serverest-api-automation/actions/workflows/ci.yml/badge.svg)

Projeto de automação de testes de API utilizando Java, RestAssured, Cucumber, JUnit 5 e GitHub Actions.

## Tecnologias Utilizadas

- Java 17
- Maven
- RestAssured
- Cucumber
- JUnit 5
- Allure Reports
- Git
- GitHub Actions

## Estrutura do Projeto

```text
src
└── test
    ├── java
    │   └── com.artenize.serverest
    │       ├── config
    │       ├── runners
    │       ├── services
    │       ├── steps
    │       └── utils
    │
    └── resources
        └── features
            ├── login.feature
            ├── usuarios.feature
            ├── produtos.feature
            └── carrinho.feature
```

## Funcionalidades Automatizadas

### Login

- Login com sucesso
- Login com senha inválida
- Login com email inexistente

### Usuários

- Listar usuários
- Cadastrar usuário
- Validar usuário duplicado
- Buscar usuário por ID
- Atualizar usuário
- Excluir usuário

### Produtos

- Listar produtos
- Buscar produto por ID
- Buscar produto inexistente
- Cadastrar produto
- Atualizar produto
- Excluir produto

### Carrinhos

- Listar carrinhos
- Buscar carrinho por ID
- Buscar carrinho inexistente
- Cadastrar carrinho
- Concluir compra
- Cancelar compra

## Cenários Implementados

```text
21 cenários automatizados
21 cenários aprovados
0 falhas
0 erros
```

## Como Executar

Clone o projeto:

```bash
git clone https://github.com/Artenize/serverest-api-automation.git
```

Acesse a pasta:

```bash
cd serverest-api-automation
```

Execute os testes:

```bash
mvn clean test
```

## Pipeline CI/CD

O projeto possui integração com GitHub Actions.

A cada push para a branch principal é executado:

```bash
mvn clean test
```

garantindo a validação automática da suíte de testes.

## Resultado da Execução

```text
Tests run: 21
Failures: 0
Errors: 0
Skipped: 0
BUILD SUCCESS
```

## Autor

**Artenize Brandão Santos Sá Teles**