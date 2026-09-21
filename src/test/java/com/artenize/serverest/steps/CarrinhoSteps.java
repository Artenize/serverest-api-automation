package com.artenize.serverest.steps;

import com.artenize.serverest.services.CarrinhoService;
import com.artenize.serverest.services.LoginService;
import com.artenize.serverest.services.ProductService;
import com.artenize.serverest.services.UserService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CarrinhoSteps {

    private final CarrinhoService carrinhoService = new CarrinhoService();
    private final ProductService productService = new ProductService();
    private final LoginService loginService = new LoginService();
    private final UserService userService = new UserService();

    private Response response;
    private String carrinhoId;
    private String produtoId;
    private String token;

    @When("realizo a consulta de carrinhos")
    public void realizoAConsultaDeCarrinhos() {

        response = carrinhoService.listarCarrinhos();
    }

    @Then("devo receber status code de carrinhos {int}")
    public void devoReceberStatusCodeDeCarrinhos(Integer statusCode) {

        assertEquals(
                statusCode,
                response.getStatusCode()
        );
    }

    @Given("que existe um carrinho cadastrado")
    public void queExisteUmCarrinhoCadastrado() {

        quePossuoUmUsuarioAutenticadoComProdutoDisponivel();

        response = carrinhoService.cadastrarCarrinho(
                token,
                produtoId,
                1
        );

        carrinhoId = response
                .jsonPath()
                .getString("_id");

        assertNotNull(carrinhoId);
    }

    @Given("que possuo um ID de carrinho inexistente")
    public void quePossuoUmIDDeCarrinhoInexistente() {

        carrinhoId = "carrinho-inexistente";
    }

    @When("realizo a busca do carrinho por ID")
    public void realizoABuscaDoCarrinhoPorID() {

        response = carrinhoService.buscarCarrinhoPorId(carrinhoId);
    }

    @Then("devo receber status code de busca de carrinho {int}")
    public void devoReceberStatusCodeDeBuscaDeCarrinho(Integer statusCode) {

        assertEquals(
                statusCode,
                response.getStatusCode()
        );
    }

    @Given("que possuo um usuário autenticado com produto disponível")
    public void quePossuoUmUsuarioAutenticadoComProdutoDisponivel() {

        String email = "carrinho_" + UUID.randomUUID() + "@qa.com";
        String senha = "teste123";

        userService.cadastrarUsuario(
                "Usuario Carrinho",
                email,
                senha,
                "true"
        );

        Response loginResponse = loginService.realizarLogin(
                email,
                senha
        );

        token = loginResponse
                .jsonPath()
                .getString("authorization");

        assertNotNull(token);

        Response produtoResponse = productService.listarProdutos();

        produtoId = produtoResponse
                .jsonPath()
                .getString("produtos[0]._id");

        assertNotNull(produtoId);
    }

    @When("realizo o cadastro de um carrinho")
    public void realizoOCadastroDeUmCarrinho() {

        response = carrinhoService.cadastrarCarrinho(
                token,
                produtoId,
                1
        );

        carrinhoId = response
                .jsonPath()
                .getString("_id");
    }

    @Then("devo receber status code de cadastro de carrinho {int}")
    public void devoReceberStatusCodeDeCadastroDeCarrinho(
            Integer statusCode
    ) {

        assertEquals(
                statusCode,
                response.getStatusCode()
        );
    }

    @Given("que existe um carrinho cadastrado para conclusão")
    public void queExisteUmCarrinhoCadastradoParaConclusao() {

        quePossuoUmUsuarioAutenticadoComProdutoDisponivel();

        realizoOCadastroDeUmCarrinho();
    }

    @When("realizo a conclusão da compra")
    public void realizoAConclusaoDaCompra() {

        response = carrinhoService.concluirCompra(token);
    }

    @Then("devo receber status code de conclusao de compra {int}")
    public void devoReceberStatusCodeDeConclusaoDeCompra(
            Integer statusCode
    ) {

        assertEquals(
                statusCode,
                response.getStatusCode()
        );
    }

    @Given("que existe um carrinho cadastrado para cancelamento")
    public void queExisteUmCarrinhoCadastradoParaCancelamento() {

        quePossuoUmUsuarioAutenticadoComProdutoDisponivel();

        realizoOCadastroDeUmCarrinho();
    }

    @When("realizo o cancelamento da compra")
    public void realizoOCancelamentoDaCompra() {

        response = carrinhoService.cancelarCompra(token);
    }

    @Then("devo receber status code de cancelamento de compra {int}")
    public void devoReceberStatusCodeDeCancelamentoDeCompra(
            Integer statusCode
    ) {

        assertEquals(
                statusCode,
                response.getStatusCode()
        );
    }
}