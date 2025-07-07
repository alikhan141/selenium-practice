package com.example;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.edge.EdgeOptions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class datepicker {
    public static void main(String[] args) {
        EdgeOptions options = new EdgeOptions();
        boolean headless = false;
        if (headless) {
            options.addArguments("--headless");
        }
        WebDriver driver = new EdgeDriver(options);
        String year = "2026";
        String month = "7";
        String date = "10";

        String[] expectedList = { month, date, year };

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
        driver.findElement(By.xpath("//button[text()= " + year + "]")).click();
        driver.findElements(By.cssSelector(".react-calendar__tile")).get(Integer.parseInt(month) - 1).click();
        driver.findElement(By.xpath("//abbr[text() = " + date + "]")).click();
        List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
        for (int i = 0; i < actualList.size(); i++) {
            System.out.println(actualList.get(i).getAttribute("value"));
            Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);

        }
        driver.quit();
    }
}
