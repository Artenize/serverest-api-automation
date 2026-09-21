package com.artenize.serverest.services;

import com.artenize.serverest.config.Configuration;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserService {

    public Response cadastrarUsuario(
            String nome,
            String email,
            String senha,
            String administrador
    ) {

        return given()
                .relaxedHTTPSValidation()
                .baseUri(Configuration.BASE_URL)
                .contentType(ContentType.JSON)
                .body(
                        String.format("""
                        {
                          "nome": "%s",
                          "email": "%s",
                          "password": "%s",
                          "administrador": "%s"
                        }
                        """,
                                nome,
                                email,
                                senha,
                                administrador
                        )
                )
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
}