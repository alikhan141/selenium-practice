package com.example;

import java.time.Duration;

import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;

public class assignment_6 {
    public static void main(String[] args) {
        EdgeOptions options = new EdgeOptions();
        boolean headless = false;
        if (headless) {
            options.addArguments("--headless");
        }

        WebDriver driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement label = driver.findElement(By.id("checkBoxOption1"));
        label.click();
        System.out.println(label.getText());

        WebElement checkbox_name = driver.findElement(By.id("checkBoxOption1"));
        System.out.println(checkbox_name.getAttribute("value"));
        String checkbox_label = checkbox_name.getAttribute("value");

        Select select = new Select(driver.findElement(By.id("dropdown-class-example")));
        select.selectByValue(checkbox_label);
        driver.findElement(By.id("name")).sendKeys(checkbox_label);
        driver.findElement(By.id("alertbtn")).click();

        Assert.assertEquals(driver.switchTo().alert().getText(),
                "Hello option1, share this practice page and share your knowledge");
        driver.switchTo().alert().accept();

        driver.quit();

    }
}
