package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class alerts {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        String name = "John Doe"; // Example name to send to the alert
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("alertbtn")).click();
        driver.switchTo().alert().accept();
        driver.findElement(By.id("confirmbtn")).click();
        driver.switchTo().alert().dismiss(); // Dismiss the alert
        driver.quit();

    }
}
