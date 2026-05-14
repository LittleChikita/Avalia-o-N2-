package com.example.demo.e2e;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginE2ETest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void deveFazerLoginComSucesso() {

        System.out.println("Iniciando teste E2E de login...");

        driver.get("http://localhost:5173/login");

        System.out.println("Página de login aberta");

        WebElement email = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("email"))
        );

        WebElement senha = driver.findElement(By.id("senha"));

        email.sendKeys("joao@test.com");
        senha.sendKeys("123456");

        System.out.println("Dados preenchidos");

        driver.findElement(By.id("botaoLogin")).click();

        System.out.println("Botão de login clicado");

        boolean loginSucesso = wait.until(driver ->
                driver.getCurrentUrl().contains("/home")
                        || driver.getCurrentUrl().contains("/admin")
        );


        assertTrue(loginSucesso, "Login deveria redirecionar para home ou admin");

        System.out.println("LOGIN REALIZADO COM SUCESSO");
        System.out.println("URL atual: " + driver.getCurrentUrl());
    }
}