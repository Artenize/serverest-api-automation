package com.artenize.serverest.steps;

import com.artenize.serverest.services.LoginService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoginSteps {

    private final LoginService loginService = new LoginService();

    private Response response;
    private String email;
    private String senha;

    @Given("que possuo um usuário válido")
    public void quePossuoUmUsuarioValido() {

        email = "fulano@qa.com";
        senha = "teste";
    }

    @Given("que possuo um email inexistente")
    public void quePossuoUmEmailInexistente() {

        email = "naoexiste@qa.com";
        senha = "teste";
    }

    @When("realizo login na API")
    public void realizoLoginNaAPI() {

        response = loginService.realizarLogin(
                email,
                senha
        );
    }

    @When("realizo login com senha inválida")
    public void realizoLoginComSenhaInvalida() {

        response = loginService.realizarLogin(
                email,
                "senhaErrada"
        );
    }

    @Then("devo receber status code {int}")
    public void devoReceberStatusCode(Integer statusCode) {

        assertEquals(
                statusCode,
                response.getStatusCode()
        );
    }

    @Then("devo receber a mensagem {string}")
    public void devoReceberAMensagem(String mensagemEsperada) {

        assertEquals(
                mensagemEsperada,
                response.jsonPath().getString("message")
        );
    }

    @Then("devo receber um token de autenticação")
    public void devoReceberUmTokenDeAutenticacao() {

        assertNotNull(
                response.jsonPath().getString("authorization")
        );
    }
}