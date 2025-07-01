package com.example;
import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class practice {
        public static void main(String[] args) {
               EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless"); // Run in headless mode
        
        WebDriver driver = new EdgeDriver(options);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("input[id = \"checkBoxOption1\"]")).click();
       Boolean check_val =  driver.findElement(By.cssSelector("input[id = \"checkBoxOption1\"]")).isSelected();
        Assert.assertEquals(check_val, true);
        driver.findElement(By.cssSelector("input[id = \"checkBoxOption1\"]")).click();
       Boolean val2 =  driver.findElement(By.cssSelector("input[id = \"checkBoxOption1\"]")).isSelected();
       Assert.assertEquals(val2, false);


        driver.findElements(By.xpath("//input[@type = \"checkbox\"]")).size();
        System.out.println("Total number of checkboxes: " + driver.findElements(By.xpath("//input[@type = \"checkbox\"]")).size());
        
    
    
    }
}
