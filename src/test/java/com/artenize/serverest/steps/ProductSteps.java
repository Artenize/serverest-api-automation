package com.artenize.serverest.steps;

import com.artenize.serverest.services.LoginService;
import com.artenize.serverest.services.ProductService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProductSteps {

    private final ProductService productService = new ProductService();
    private final LoginService loginService = new LoginService();

    private Response response;
    private String produtoId;
    private String token;
    private String nomeProduto;

    @When("realizo a consulta de produtos")
    public void realizoAConsultaDeProdutos() {

        response = productService.listarProdutos();
    }

    @Then("devo receber status code de produtos {int}")
    public void devoReceberStatusCodeDeProdutos(Integer statusCode) {

        assertEquals(
                statusCode,
                response.getStatusCode()
        );
    }

    @Given("que existe um produto cadastrado")
    public void queExisteUmProdutoCadastrado() {

        response = productService.listarProdutos();

        produtoId = response
                .jsonPath()
                .getString("produtos[0]._id");

        assertNotNull(produtoId);
    }

    @Given("que possuo um ID de produto inexistente")
    public void quePossuoUmIDDeProdutoInexistente() {

        produtoId = "produto-inexistente";
    }

    @When("realizo a busca do produto por ID")
    public void realizoABuscaDoProdutoPorID() {

        response = productService.buscarProdutoPorId(produtoId);
    }

    @Then("devo receber status code de busca de produto {int}")
    public void devoReceberStatusCodeDeBuscaDeProduto(Integer statusCode) {

        assertEquals(
                statusCode,
                response.getStatusCode()
        );
    }

    @Given("que possuo um usuário administrador autenticado")
    public void quePossuoUmUsuarioAdministradorAutenticado() {

        Response loginResponse = loginService.realizarLogin(
                "fulano@qa.com",
                "teste"
        );

        token = loginResponse
                .jsonPath()
                .getString("authorization");

        assertNotNull(token);

        nomeProduto = "Produto_" + UUID.randomUUID();
    }

    @When("realizo o cadastro de um produto")
    public void realizoOCadastroDeUmProduto() {

        response = productService.cadastrarProduto(
                token,
                nomeProduto,
                100,
                "Produto de teste",
                10
        );

        produtoId = response
                .jsonPath()
                .getString("_id");
    }

    @Then("devo receber status code de cadastro de produto {int}")
    public void devoReceberStatusCodeDeCadastroDeProduto(Integer statusCode) {

        assertEquals(
                statusCode,
                response.getStatusCode()
        );
    }

    @Given("que existe um produto cadastrado para atualização")
    public void queExisteUmProdutoCadastradoParaAtualizacao() {

        quePossuoUmUsuarioAdministradorAutenticado();

        realizoOCadastroDeUmProduto();

        assertNotNull(produtoId);
    }

    @When("realizo a atualização do produto")
    public void realizoAAtualizacaoDoProduto() {

        response = productService.atualizarProduto(
                token,
                produtoId,
                nomeProduto + "_Atualizado",
                200,
                "Produto atualizado",
                20
        );
    }

    @Then("devo receber status code de atualizacao de produto {int}")
    public void devoReceberStatusCodeDeAtualizacaoDeProduto(
            Integer statusCode
    ) {

        assertEquals(
                statusCode,
                response.getStatusCode()
        );
    }

    @Given("que existe um produto cadastrado para exclusão")
    public void queExisteUmProdutoCadastradoParaExclusao() {

        quePossuoUmUsuarioAdministradorAutenticado();

        realizoOCadastroDeUmProduto();

        assertNotNull(produtoId);
    }

    @When("realizo a exclusão do produto")
    public void realizoAExclusaoDoProduto() {

        response = productService.excluirProduto(
                token,
                produtoId
        );
    }

    @Then("devo receber status code de exclusao de produto {int}")
    public void devoReceberStatusCodeDeExclusaoDeProduto(
            Integer statusCode
    ) {

        assertEquals(
                statusCode,
                response.getStatusCode()
        );
    }
}