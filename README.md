# 🚀 ServeRest API Automation

![Build Status](https://github.com/Artenize/serverest-api-automation/actions/workflows/ci.yml/badge.svg)

Projeto de automação de testes de API desenvolvido utilizando **Java**, **RestAssured**, **Cucumber**, **JUnit 5**, **GitHub Actions** e **Allure Report**.

---

## 📋 Sobre o Projeto

Este projeto tem como objetivo validar os principais fluxos da API **ServeRest**, cobrindo cenários positivos e negativos dos principais recursos da aplicação.

A suíte está integrada ao **GitHub Actions**, executando automaticamente a cada push realizado na branch principal e publicando os resultados através do **Allure Report** hospedado no **GitHub Pages**.

---

## 🛠 Tecnologias Utilizadas

- Java 17
- Maven
- RestAssured
- Cucumber
- JUnit 5
- Git
- GitHub
- GitHub Actions
- Allure Report
- GitHub Pages

---

## 📁 Estrutura do Projeto

```text
src
└── test
    ├── java
    │   └── com.artenize.serverest
    │       ├── config
    │       ├── runners
    │       ├── services
    │       └── steps
    │
    └── resources
        └── features
            ├── login.feature
            ├── usuarios.feature
            ├── produtos.feature
            └── carrinho.feature
```

---

## ✅ Cenários Automatizados

### Login

- Login com sucesso
- Login com senha inválida
- Login com email inexistente

### Usuários

- Listar usuários
- Cadastrar usuário
- Validar e-mail duplicado
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

---

## 📊 Cobertura Atual

```text
21 cenários automatizados
21 cenários aprovados
0 falhas
0 erros
100% de sucesso
```

---

## ▶️ Como Executar

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

---

## 🔄 Integração Contínua

O projeto possui pipeline CI/CD utilizando GitHub Actions.

A cada push realizado na branch principal, a pipeline executa automaticamente:

```bash
mvn clean test
```

validando toda a suíte de testes.

---

## 📈 Allure Report

Relatório publicado automaticamente através do GitHub Pages:

🔗 **https://artenize.github.io/serverest-api-automation/**

O relatório apresenta:

- Status das execuções
- Histórico dos testes
- Features executadas
- Tempo de execução
- Dashboards visuais
- Métricas da suíte

---

## 🏆 Resultado da Última Execução

```text
Tests run: 21
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```

---

## 👨‍💻 Autor

**Artenize Brandão Santos Sá Teles**

- GitHub: https://github.com/Artenize
