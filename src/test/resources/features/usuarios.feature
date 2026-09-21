@usuarios
Feature: Usuários

  Como usuário da ServeRest
  Quero gerenciar usuários
  Para manter os cadastros atualizados

  @positivo
  Scenario: Listar usuários

    When realizo a consulta de usuários
    Then devo receber status code de usuarios 200

  @positivo
  Scenario: Cadastrar usuário com sucesso

    Given que possuo os dados de um novo usuário
    When realizo o cadastro do usuário
    Then devo receber status code de cadastro 201
    And devo receber a mensagem de cadastro "Cadastro realizado com sucesso"

  @negativo
  Scenario: Cadastrar usuário com email já existente

    Given que possuo um usuário já cadastrado
    When realizo o cadastro do usuário novamente
    Then devo receber status code de cadastro 400
    And devo receber a mensagem de cadastro "Este email já está sendo usado"

  @positivo
  Scenario: Buscar usuário por ID

    Given que existe um usuário cadastrado
    When realizo a busca do usuário por ID
    Then devo receber status code de busca 200

  @positivo
  Scenario: Atualizar usuário

    Given que existe um usuário cadastrado para atualização
    When realizo a atualização do usuário
    Then devo receber status code de atualizacao 200

  @positivo
  Scenario: Excluir usuário

    Given que existe um usuário cadastrado para exclusão
    When realizo a exclusão do usuário
    Then devo receber status code de exclusao 200