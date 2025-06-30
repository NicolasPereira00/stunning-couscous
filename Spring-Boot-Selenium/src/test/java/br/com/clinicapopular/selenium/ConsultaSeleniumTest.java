package br.com.clinicapopular.selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConsultaSeleniumTest {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/form.html");
    }

    @Test
    public void deveAgendarConsultaComCpf() {
        driver.findElement(By.id("nome")).sendKeys("Carlos");
        driver.findElement(By.id("cpf")).sendKeys("78945612300");
        driver.findElement(By.id("dataHora")).sendKeys("2025-07-10 09:00");
        driver.findElement(By.cssSelector("button")).click();

        WebElement msg = driver.findElement(By.id("mensagem"));
        Assertions.assertTrue(msg.getText().contains("Carlos (CPF: 78945612300)"));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}