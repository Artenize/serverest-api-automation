package com.artenize.serverest.services;

import com.artenize.serverest.config.Configuration;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CarrinhoService {

    public Response listarCarrinhos() {

        return given()
                .relaxedHTTPSValidation()
                .baseUri(Configuration.BASE_URL)
                .when()
                .get("/carrinhos");
    }

    public Response buscarCarrinhoPorId(String carrinhoId) {

        return given()
                .relaxedHTTPSValidation()
                .baseUri(Configuration.BASE_URL)
                .when()
                .get("/carrinhos/" + carrinhoId);
    }

    public Response cadastrarCarrinho(
            String token,
            String produtoId,
            int quantidade
    ) {

        String body = "{"
                + "\"produtos\":[{"
                + "\"idProduto\":\"" + produtoId + "\","
                + "\"quantidade\":" + quantidade
                + "}]"
                + "}";

        return given()
                .relaxedHTTPSValidation()
                .baseUri(Configuration.BASE_URL)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body(body)
                .when()
                .post("/carrinhos");
    }

    public Response concluirCompra(String token) {

        return given()
                .relaxedHTTPSValidation()
                .baseUri(Configuration.BASE_URL)
                .header("Authorization", token)
                .when()
                .delete("/carrinhos/concluir-compra");
    }

    public Response cancelarCompra(String token) {

        return given()
                .relaxedHTTPSValidation()
                .baseUri(Configuration.BASE_URL)
                .header("Authorization", token)
                .when()
                .delete("/carrinhos/cancelar-compra");
    }
}