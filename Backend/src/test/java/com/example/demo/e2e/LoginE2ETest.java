package com.example.demo.e2e;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginE2ETest {

    @Test
    void deveFazerLogin() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        try {
            driver.get("http://localhost:4200/login");

            driver.findElement(By.id("email")).sendKeys("admin@email.com");
            driver.findElement(By.id("senha")).sendKeys("123456");
            driver.findElement(By.id("botaoLogin")).click();

            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}