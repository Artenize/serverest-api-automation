@usuarios
Feature: Usuários

  Como usuário da ServeRest
  Quero gerenciar usuários
  Para manter os cadastros atualizados


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