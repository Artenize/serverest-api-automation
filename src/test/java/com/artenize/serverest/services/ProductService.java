package com.artenize.serverest.services;

import com.artenize.serverest.config.Configuration;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ProductService {

    public Response listarProdutos() {

        return given()
                .relaxedHTTPSValidation()
                .baseUri(Configuration.BASE_URL)
                .when()
                .get("/produtos");
    }

    public Response buscarProdutoPorId(String produtoId) {

        return given()
                .relaxedHTTPSValidation()
                .baseUri(Configuration.BASE_URL)
                .when()
                .get("/produtos/" + produtoId);
    }

    public Response cadastrarProduto(
            String token,
            String nome,
            Integer preco,
            String descricao,
            Integer quantidade
    ) {

        String body = "{"
                + "\"nome\":\"" + nome + "\","
                + "\"preco\":" + preco + ","
                + "\"descricao\":\"" + descricao + "\","
                + "\"quantidade\":" + quantidade
                + "}";

        return given()
                .relaxedHTTPSValidation()
                .baseUri(Configuration.BASE_URL)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body(body)
                .when()
                .post("/produtos");
    }

    public Response atualizarProduto(
            String token,
            String produtoId,
            String nome,
            Integer preco,
            String descricao,
            Integer quantidade
    ) {

        String body = "{"
                + "\"nome\":\"" + nome + "\","
                + "\"preco\":" + preco + ","
                + "\"descricao\":\"" + descricao + "\","
                + "\"quantidade\":" + quantidade
                + "}";

        return given()
                .relaxedHTTPSValidation()
                .baseUri(Configuration.BASE_URL)
                .contentType(ContentType.JSON)
                .header("Authorization", token)
                .body(body)
                .when()
                .put("/produtos/" + produtoId);
    }

    public Response excluirProduto(
            String token,
            String produtoId
    ) {

        return given()
                .relaxedHTTPSValidation()
                .baseUri(Configuration.BASE_URL)
                .header("Authorization", token)
                .when()
                .delete("/produtos/" + produtoId);
    }
}