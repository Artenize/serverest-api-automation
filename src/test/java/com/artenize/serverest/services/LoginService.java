package com.artenize.serverest.services;

import com.artenize.serverest.config.Configuration;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LoginService {

    public Response realizarLogin(String email, String senha) {

        return given()
                .relaxedHTTPSValidation()
                .baseUri(Configuration.BASE_URL)
                .contentType(ContentType.JSON)
                .body(
                        String.format("""
                                {
                                  "email": "%s",
                                  "password": "%s"
                                }
                                """, email, senha)
                )
                .when()
                .post("/login");
    }
}