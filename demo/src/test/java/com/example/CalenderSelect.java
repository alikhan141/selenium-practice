package com.example;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class CalenderSelect {
    public static void main(String[] args) throws InterruptedException {
        // This class is intended to handle calendar selection functionality.
        // Implementation will depend on the specific requirements and the web application being tested.
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless"); // Run in headless mode if needed
        WebDriver driver = new EdgeDriver(options);
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        Thread.sleep(1000); // Wait for the page to load
        // driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("Style").contains("1"));
        if (driver.findElement(By.id("Div1")).getDomAttribute("Style").contains("1")) {
            System.out.println("Element is enabled");
        } else {
            System.out.println("Element is disabled");
            
        }
        
    }
    
}
