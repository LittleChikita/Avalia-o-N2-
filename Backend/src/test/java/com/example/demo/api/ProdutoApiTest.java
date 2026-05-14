package com.example.demo.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ProdutoApiTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    void deveCriarProduto() {

        String json = """
    {
        "nome": "Pizza",
        "descricao": "Grande",
        "preco": 50.0,
        "categoria": "COMIDA"
    }
    """;

        given()
                .contentType("application/json")
                .body(json)
                .when()
                .post("/produtos")
                .then()
                .statusCode(anyOf(is(200), is(201)))
                .log().body()
                .body("id", notNullValue())
                .body("nome", equalTo("Pizza"));
    }
}