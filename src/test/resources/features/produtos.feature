@produtos
Feature: Produtos

  Como administrador da ServeRest
  Quero gerenciar produtos
  Para manter o catálogo atualizado

  @positivo
  Scenario: Listar produtos

    When realizo a consulta de produtos
    Then devo receber status code de produtos 200

  @positivo
  Scenario: Buscar produto por ID

    Given que existe um produto cadastrado
    When realizo a busca do produto por ID
    Then devo receber status code de busca de produto 200

  @negativo
  Scenario: Buscar produto com ID inexistente

    Given que possuo um ID de produto inexistente
    When realizo a busca do produto por ID
    Then devo receber status code de busca de produto 400

  @positivo
  Scenario: Cadastrar produto

    Given que possuo um usuário administrador autenticado
    When realizo o cadastro de um produto
    Then devo receber status code de cadastro de produto 201

  @positivo
  Scenario: Atualizar produto

    Given que existe um produto cadastrado para atualização
    When realizo a atualização do produto
    Then devo receber status code de atualizacao de produto 200

  @positivo
  Scenario: Excluir produto

    Given que existe um produto cadastrado para exclusão
    When realizo a exclusão do produto
    Then devo receber status code de exclusao de produto 200