package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;
// import org.openqa.selenium.edge.EdgeOptions;

public class Dropdown_radiobtn {

    public static void main(String[] args) throws InterruptedException {

        // EdgeOptions options = new EdgeOptions();
        // options.addArguments("--headless"); // Run in headless mode
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1000);
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();

        String fetched_text = driver.findElement(By.id("divpaxinfo")).getText();

        System.out.println(fetched_text);
        driver.findElement(By.xpath("//a[@value='AIP']fetched_text")).click();

        // Close the browser
        driver.quit();
    }

}