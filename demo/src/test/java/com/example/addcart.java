package com.example;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addcart {
    public static void main(String[] args) {
        EdgeOptions options = new EdgeOptions();

        boolean runheadless = true;
        if (runheadless) {
            options.addArguments("--headless");
        }

        WebDriver driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        additems(driver);
        checkout(driver, wait);
        driver.quit();

    }

    public static void additems(WebDriver driver) {
        List<String> items = Arrays.asList("Cucumber", "Brocolli", "Beetroot", "Carrot");
        List<WebElement> titles = driver.findElements(By.cssSelector("h4[class*='product']"));
        int j = 0;

        for (int i = 0; i < titles.size(); i++) {

            String[] name = titles.get(i).getText().split("-");
            String formattedName = name[0].trim();
            if (items.contains(formattedName)) {
                j++;
                // Click on the add to cart button for the matching product

                driver.findElement(By.xpath("//div[@class = \"product-action\"] //button[@type='button']")).click();
                System.out.println("Added to cart: " + formattedName);
                if (j == items.size()) {
                    System.out.println("All items added to cart.");
                    break; // Exit the loop if all items are added

                }
            }

        }

    }

    public static void checkout(WebDriver driver, WebDriverWait wait) {
        driver.findElement(By.cssSelector("a[class ='cart-icon']")).click();
        driver.findElement(By.xpath("//button[text() ='PROCEED TO CHECKOUT']")).click();
        driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button[class='promoBtn']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        String promo_message = driver.findElement(By.cssSelector("span.promoInfo")).getText();

        System.out.println("Promo message: " + promo_message);

    }
}
