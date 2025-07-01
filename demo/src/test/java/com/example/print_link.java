package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class print_link {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());
        System.out.println(driver.findElements(By.cssSelector(".gf-t a")).size());
        driver.quit();

    }
}
