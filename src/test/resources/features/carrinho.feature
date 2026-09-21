@carrinhos
Feature: Carrinhos

  Como usuário da ServeRest
  Quero gerenciar carrinhos
  Para realizar compras

  @positivo
  Scenario: Listar carrinhos

    When realizo a consulta de carrinhos
    Then devo receber status code de carrinhos 200

  @positivo
  Scenario: Buscar carrinho por ID

    Given que existe um carrinho cadastrado
    When realizo a busca do carrinho por ID
    Then devo receber status code de busca de carrinho 200

  @negativo
  Scenario: Buscar carrinho inexistente

    Given que possuo um ID de carrinho inexistente
    When realizo a busca do carrinho por ID
    Then devo receber status code de busca de carrinho 400

  @positivo
  Scenario: Cadastrar carrinho

    Given que possuo um usuário autenticado com produto disponível
    When realizo o cadastro de um carrinho
    Then devo receber status code de cadastro de carrinho 201

  @positivo
  Scenario: Concluir compra

    Given que existe um carrinho cadastrado para conclusão
    When realizo a conclusão da compra
    Then devo receber status code de conclusao de compra 200

  @positivo
  Scenario: Cancelar compra

    Given que existe um carrinho cadastrado para cancelamento
    When realizo o cancelamento da compra
    Then devo receber status code de cancelamento de compra 200