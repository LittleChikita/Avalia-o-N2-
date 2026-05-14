package com.example.demo.e2e;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CadastroUsuarioE2ETest {

    @Test
    void deveCadastrarUsuario() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        try {
            driver.get("http://localhost:5173/usuarios");

            driver.findElement(By.id("nome")).sendKeys("Joao Teste");
            driver.findElement(By.id("email")).sendKeys("joao@test.com");
            driver.findElement(By.id("senha")).sendKeys("123456");
            driver.findElement(By.id("cargo")).sendKeys("ADMIN");

            driver.findElement(By.id("botaoSalvar")).click();

            Thread.sleep(2000);

            String page = driver.getPageSource();

            assertTrue(page.contains("Usuário cadastrado")
                    || page.toLowerCase().contains("joao"));

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }
}