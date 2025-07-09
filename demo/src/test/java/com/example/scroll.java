package com.example;

import org.openqa.selenium.edge.EdgeOptions;

import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class scroll {
    public static void main(String[] args) {

        boolean headless = true;
        EdgeOptions options = new EdgeOptions();
        if (headless) {
            options.addArguments("--headless");
        }
        WebDriver driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum = 0;
        for (int i = 0; i < values.size(); i++) {
            sum = sum + Integer.parseInt(values.get(i).getText());

        }
        System.out.println(sum);
        // Total Amount Collected: 296

        String value = driver.findElement(By.cssSelector(".totalAmount")).getText();
        String[] split = value.split(":");
        String extracted_value = split[1].trim();
        int final_value = Integer.parseInt(extracted_value);
        Assert.assertEquals(sum, final_value);
        driver.quit();

    }
}
