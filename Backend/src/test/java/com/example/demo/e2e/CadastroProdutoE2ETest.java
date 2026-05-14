package com.example.demo.e2e;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CadastroProdutoE2ETest {

    @Test
    void deveCadastrarProduto() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        try {
            driver.get("http://localhost:4200/produtos");

            driver.findElement(By.id("nome")).sendKeys("Pizza");
            driver.findElement(By.id("descricao")).sendKeys("Grande");
            driver.findElement(By.id("preco")).sendKeys("50");
            driver.findElement(By.id("botaoSalvar")).click();

            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}