package com.example.demo.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ProdutoApiGetTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    void deveListarProdutos() {

        given()
                .when()
                .get("/produtos")
                .then()
                .statusCode(200)
                .log().body()
                .body("$", not(empty()));
    }
}