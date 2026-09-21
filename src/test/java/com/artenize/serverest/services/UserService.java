package com.artenize.serverest.services;

import com.artenize.serverest.config.Configuration;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserService {

    public Response listarUsuarios() {

        return given()
                .relaxedHTTPSValidation()
                .baseUri(Configuration.BASE_URL)
                .when()
                .get("/usuarios");
    }

    public Response cadastrarUsuario(
            String nome,
            String email,
            String senha,
            String administrador
    ) {

        String body = "{"
                + "\"nome\":\"" + nome + "\","
                + "\"email\":\"" + email + "\","
                + "\"password\":\"" + senha + "\","
                + "\"administrador\":\"" + administrador + "\""
                + "}";

        return given()
                .relaxedHTTPSValidation()
                .baseUri(Configuration.BASE_URL)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/usuarios");
    }

    public Response buscarUsuarioPorId(String idUsuario) {

        return given()
                .relaxedHTTPSValidation()
                .baseUri(Configuration.BASE_URL)
                .when()
                .get("/usuarios/" + idUsuario);
    }

    public Response atualizarUsuario(
            String idUsuario,
            String nome,
            String email,
            String senha,
            String administrador
    ) {

        String body = "{"
                + "\"nome\":\"" + nome + "\","
                + "\"email\":\"" + email + "\","
                + "\"password\":\"" + senha + "\","
                + "\"administrador\":\"" + administrador + "\""
                + "}";

        return given()
                .relaxedHTTPSValidation()
                .baseUri(Configuration.BASE_URL)
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .put("/usuarios/" + idUsuario);
    }

    public Response excluirUsuario(String idUsuario) {

        return given()
                .relaxedHTTPSValidation()
                .baseUri(Configuration.BASE_URL)
                .when()
                .delete("/usuarios/" + idUsuario);
    }
}