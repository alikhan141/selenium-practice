package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class e2e {
    public static void main(String[] args) throws InterruptedException {
        // EdgeOptions options = new EdgeOptions();
        // options.addArguments("--headless"); // Run in headless mode if needed
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(1000); // Wait for the dropdown to be interactive
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(2000); // Wait for the dropdown to be interactive
        driver.findElement(
                By.xpath("//div[@id =\"glsctl00_mainContent_ddl_destinationStation1_CTNR\"] //a[@value='ATQ']"))
                .click();
        driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[class*='ui-state-active']")).click(); // Select today's date
        Thread.sleep(1000);
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(1000);
        for (int i = 0; i <= 5; i++) {
            driver.findElement(By.id("hrefIncAdt")).click(); // Increment adult count
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        WebElement dropdown_element = driver.findElement(By.cssSelector("select[name*='ListCurrency']"));
        Select dropdown = new Select(dropdown_element);
        dropdown.selectByIndex(1); // Select currency by index
        driver.findElement(By.cssSelector("input[name*='chk_SeniorCitizenDiscount']")).click(); // Click on Senior
                                                                                                // Citizen Discount
                                                                                                // checkbox
        driver.findElement(By.cssSelector("input[name*='FindFlights']")).click(); // Click on the search button
        driver.quit();
    }
}
