package com.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;

public class scope_limited {
    public static void main(String[] args) {

        EdgeOptions options = new EdgeOptions();
        boolean headless = false;
        if (headless) {
            options.addArguments("--headless");
        }

        WebDriver driver = new EdgeDriver(options);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());
        System.out.println(driver.findElements(By.cssSelector(".gf-t a")).size());
        WebElement footer = driver.findElement(By.id("gf-BIG"));

        // one way of getting footer links
        // List<WebElement> footerLinks =
        // footer.findElements(By.xpath("//table/tbody/tr/td[1] /ul /li /a"));
        // System.out.println(footerLinks.size());

        // another way of getting footer links
        WebElement column_driver = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(column_driver.findElements(By.tagName("a")).size());
        List<WebElement> footerlinks = column_driver.findElements(By.tagName("a"));

        Actions action = new Actions(driver);

        // clicking on the each element on a tag
        for (int i = 1; i < footerlinks.size(); i++) {
            WebElement link = footerlinks.get(i);

        }

        driver.quit();

    }
}
