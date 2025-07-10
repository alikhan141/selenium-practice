package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class borken_links {
    public static void main(String[] args) {
        boolean headless = false;
        EdgeOptions options = new EdgeOptions();
        if (headless) {
            options.addArguments("--headless");
            options.setAcceptInsecureCerts(true);
        }
        WebDriver driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("a[href*='soap']")).click();
        driver.quit();

    }

}
