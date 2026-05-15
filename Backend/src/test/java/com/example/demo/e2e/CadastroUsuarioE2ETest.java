package com.example.demo.e2e;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CadastroUsuarioE2ETest {

    @Test
    void deveLogarENavegarECadastrarUsuario() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            driver.get("http://localhost:5173/login");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("teste@gmail.com");
            driver.findElement(By.id("senha")).sendKeys("123456");

            driver.findElement(By.cssSelector("button")).click();

            wait.until(d -> d.getCurrentUrl().contains("home"));

            driver.get("http://localhost:5173/usuarios/cadastro");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nome"))).sendKeys("João Teste");

            driver.findElement(By.id("email")).sendKeys("joao" + System.currentTimeMillis() + "@test.com");
            driver.findElement(By.id("senha")).sendKeys("123456");

            // opcional: select cargo
            driver.findElement(By.id("cargo")).sendKeys("FUNCIONARIO");

            driver.findElement(By.id("botaoSalvar")).click();

            // 5 - validação de sucesso
            boolean sucesso = wait.until(d ->
                    d.getPageSource().toLowerCase().contains("usuário cadastrado")
                            || d.getPageSource().toLowerCase().contains("sucesso")
            );

            assertTrue(sucesso);

        } finally {
            driver.quit();
        }
    }
}