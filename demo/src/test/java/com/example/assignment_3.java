package com.example;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class assignment_3 {
    public static void main(String[] args) {

        EdgeOptions options = new EdgeOptions();

        boolean runheadless = false;
        if (runheadless) {
            options.addArguments("--headless");
        }

        WebDriver driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        login(driver, wait);
        additems(driver);
        checkout(driver);
        driver.quit();

    }

    public static void login(WebDriver driver, WebDriverWait wait) {
        String username = driver.findElement(By.cssSelector("p.text-center.text-white b:nth-of-type(1)")).getText();
        String password = driver.findElement(By.cssSelector("p.text-center.text-white b:nth-of-type(2)")).getText();
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value ='user']")).click();
        driver.findElement(By.id("okayBtn")).click();
        WebElement dropdown = driver.findElement(By.cssSelector("select[class ='form-control']"));
        Select select = new Select(dropdown);
        select.selectByIndex(2);
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();

    }

    public static void additems(WebDriver driver) {
        List<WebElement> titles = driver.findElements(By.tagName("app-card"));
        for (WebElement card : titles) {
            WebElement addButton = card.findElement(By.cssSelector("button.btn.btn-info"));
            addButton.click();
        }

    }

    public static void checkout(WebDriver driver) {
        driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
        driver.findElement(By.cssSelector("button[class*='success']")).click();
        driver.findElement(By.id("country")).sendKeys("germany");
        driver.findElement(By.xpath("//div[@class='suggestions']")).click();
        driver.findElement(By.cssSelector("input[value*='Purchase']")).click();

    }
}
