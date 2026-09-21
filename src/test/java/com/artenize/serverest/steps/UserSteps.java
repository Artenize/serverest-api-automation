package com.artenize.serverest.steps;

import com.artenize.serverest.services.UserService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserSteps {

    private final UserService userService = new UserService();

    private Response response;
    private String email;
    private String senha;
    private String usuarioId;

    @When("realizo a consulta de usuários")
    public void realizoAConsultaDeUsuarios() {

        response = userService.listarUsuarios();
    }

    @Then("devo receber status code de usuarios {int}")
    public void devoReceberStatusCodeDeUsuarios(Integer statusCode) {

        assertEquals(
                statusCode,
                response.getStatusCode()
        );
    }

    @Given("que possuo os dados de um novo usuário")
    public void quePossuoOsDadosDeUmNovoUsuario() {

        email = "user_" + UUID.randomUUID() + "@qa.com";
        senha = "teste123";
    }

    @When("realizo o cadastro do usuário")
    public void realizoOCadastroDoUsuario() {

        response = userService.cadastrarUsuario(
                "Usuário Teste",
                email,
                senha,
                "true"
        );
    }

    @Then("devo receber status code de cadastro {int}")
    public void devoReceberStatusCodeDeCadastro(Integer statusCode) {

        assertEquals(
                statusCode,
                response.getStatusCode()
        );
    }

    @Then("devo receber a mensagem de cadastro {string}")
    public void devoReceberAMensagemDeCadastro(String mensagemEsperada) {

        assertEquals(
                mensagemEsperada,
                response.jsonPath().getString("message")
        );
    }

    @Given("que possuo um usuário já cadastrado")
    public void quePossuoUmUsuarioJaCadastrado() {

        email = "user_" + UUID.randomUUID() + "@qa.com";
        senha = "teste123";

        userService.cadastrarUsuario(
                "Usuário Teste",
                email,
                senha,
                "true"
        );
    }

    @When("realizo o cadastro do usuário novamente")
    public void realizoOCadastroDoUsuarioNovamente() {

        response = userService.cadastrarUsuario(
                "Usuário Teste",
                email,
                senha,
                "true"
        );
    }

    @Given("que existe um usuário cadastrado")
    public void queExisteUmUsuarioCadastrado() {

        email = "user_" + UUID.randomUUID() + "@qa.com";
        senha = "teste123";

        response = userService.cadastrarUsuario(
                "Usuário Teste",
                email,
                senha,
                "true"
        );

        usuarioId = response.jsonPath().getString("_id");

        assertNotNull(usuarioId);
    }

    @When("realizo a busca do usuário por ID")
    public void realizoABuscaDoUsuarioPorID() {

        response = userService.buscarUsuarioPorId(usuarioId);
    }

    @Then("devo receber status code de busca {int}")
    public void devoReceberStatusCodeDeBusca(Integer statusCode) {

        assertEquals(
                statusCode,
                response.getStatusCode()
        );
    }

    @Given("que existe um usuário cadastrado para atualização")
    public void queExisteUmUsuarioCadastradoParaAtualizacao() {

        email = "user_" + UUID.randomUUID() + "@qa.com";
        senha = "teste123";

        response = userService.cadastrarUsuario(
                "Usuário Teste",
                email,
                senha,
                "true"
        );

        usuarioId = response.jsonPath().getString("_id");

        assertNotNull(usuarioId);
    }

    @When("realizo a atualização do usuário")
    public void realizoAAtualizacaoDoUsuario() {

        response = userService.atualizarUsuario(
                usuarioId,
                "Usuário Atualizado",
                email,
                senha,
                "true"
        );
    }

    @Then("devo receber status code de atualizacao {int}")
    public void devoReceberStatusCodeDeAtualizacao(Integer statusCode) {

        assertEquals(
                statusCode,
                response.getStatusCode()
        );
    }

    @Given("que existe um usuário cadastrado para exclusão")
    public void queExisteUmUsuarioCadastradoParaExclusao() {

        email = "user_" + UUID.randomUUID() + "@qa.com";
        senha = "teste123";

        response = userService.cadastrarUsuario(
                "Usuário Teste",
                email,
                senha,
                "true"
        );

        usuarioId = response.jsonPath().getString("_id");

        assertNotNull(usuarioId);
    }

    @When("realizo a exclusão do usuário")
    public void realizoAExclusaoDoUsuario() {

        response = userService.excluirUsuario(usuarioId);
    }

    @Then("devo receber status code de exclusao {int}")
    public void devoReceberStatusCodeDeExclusao(Integer statusCode) {

        assertEquals(
                statusCode,
                response.getStatusCode()
        );
    }
}