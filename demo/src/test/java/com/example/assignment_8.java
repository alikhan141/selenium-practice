package com.example;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class assignment_8 {
    public static void main(String[] args) throws InterruptedException {
        boolean headless = false;
        EdgeOptions options = new EdgeOptions();
        if (headless) {
            options.addArguments("--headless");

        }
        WebDriver driver = new EdgeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement input = driver.findElement(By.id("autocomplete"));
        input.sendKeys("pak"); // Type in the input
        Thread.sleep(1000); // Wait for suggestions to load (better: use WebDriverWait)

        input.sendKeys(Keys.ARROW_DOWN); // Highlight first suggestion// Move to next suggestion (optional)
        input.sendKeys(Keys.ENTER);
        String final_value = driver.findElement(By.id("autocomplete")).getAttribute("value");
        System.out.println(final_value);
        driver.quit();

    }
}
