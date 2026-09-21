Feature: Login

  Como usuário da ServeRest
  Quero autenticar na API
  Para acessar recursos protegidos

  @positivo
  Scenario: Realizar login com sucesso

    Given que possuo um usuário válido
    When realizo login na API
    Then devo receber status code 200
    And devo receber a mensagem "Login realizado com sucesso"
    And devo receber um token de autenticação

  @negativo
  Scenario: Realizar login com senha inválida

    Given que possuo um usuário válido
    When realizo login com senha inválida
    Then devo receber status code 401
    And devo receber a mensagem "Email e/ou senha inválidos"

  @negativo
  Scenario: Realizar login com email inexistente

    Given que possuo um email inexistente
    When realizo login na API
    Then devo receber status code 401
    And devo receber a mensagem "Email e/ou senha inválidos"


  