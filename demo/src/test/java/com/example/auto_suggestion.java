package com.example;


import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;

public class auto_suggestion {
    public static void main(String[] args) throws InterruptedException {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless"); // Run in headless mode
        
        WebDriver driver = new EdgeDriver(options);
        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(1000);
     List<WebElement> options_list=   driver.findElements(By.cssSelector("li[class*=\"ui\"] a"));
     for (WebElement items : options_list)
     {
        if (items.getText().equalsIgnoreCase("austria"))
        {
            items.click();
            break;
        }
     }

     // checkboxes automation 
     
    // Assert.assertTrue(driver.findElement(By.cssSelector("input[id*=\"SeniorCitizenDiscount\" ]")).isSelected());
     driver.findElement(By.cssSelector("input[id*=\"SeniorCitizenDiscount\" ]")).click();
    Assert.assertTrue(driver.findElement(By.cssSelector("input[id*=\"SeniorCitizenDiscount\" ]")).isSelected());
     System.out.println("Total number of checkboxes: " + driver.findElements(By.cssSelector("input[type = 'checkbox']")).size());
     Assert.assertEquals(driver.findElements(By.cssSelector("input[type = 'checkbox']")).size(), 6);
    
     driver.quit(); 
    
    }
}
