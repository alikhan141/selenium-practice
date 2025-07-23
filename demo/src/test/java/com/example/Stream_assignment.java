package com.example;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;

public class Stream_assignment {
    public static void main(String[] args) {
        EdgeOptions options = new EdgeOptions();
        boolean headless = false;
        if (headless) {
            options.addArguments("--headless");
        }

        WebDriver driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector("th[role*='columnheader']:nth-child(1)")).click();
        List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));
        elements.stream().map(s -> s.getText()).sorted().collect(Collectors.toList());

        driver.quit();
    }
}
