package com.example;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.interactions.Actions;

public class actions {

    public static void main(String[] args) throws InterruptedException {

        boolean isHeadless = false; // Change to false if you want to see the browser
        ChromeOptions options = new ChromeOptions();
        if (isHeadless) {

            options.addArguments("--headless=new");
        }

        WebDriver driver = new ChromeDriver(options);
        // driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com/");
        // driver.findElement(By.id("nav-link-accountList")).click();
        Actions actions = new Actions(driver);

        // Saving elements in variables
        WebElement searchbox = driver.findElement(By.cssSelector("input[id*='twotabsearchtextbox"));
        WebElement move = driver.findElement(By.xpath("//div[@id='nav-link-accountList']"));

        // actions performs a series of actions on the web elements
        actions.moveToElement(searchbox).click().keyDown(Keys.SHIFT).sendKeys("laptop").doubleClick().build().perform();
        actions.moveToElement(move).contextClick().build().perform();

    }
}
