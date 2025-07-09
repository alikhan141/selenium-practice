package com.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class assignment_7 {
    public static void main(String[] args) {

        Boolean headless = false;
        EdgeOptions options = new EdgeOptions();
        if (headless) {
            options.addArguments("--headless");
        }

        EdgeDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        // Task # 1:
        List<WebElement> values = driver.findElements(By.xpath("//table[@name='courses'] //td[2]"));
        System.out.println(values.size());

        // task # 2:
        List<WebElement> rows = driver.findElements(By.xpath("//table[@name='courses'] //tr[1] /th"));
        System.out.println(rows.size());

        // Task # 3:
        System.out.println(driver.findElement(By.xpath("//table[@name='courses'] //tr[3]")).getText());

        driver.quit();

    }
}
