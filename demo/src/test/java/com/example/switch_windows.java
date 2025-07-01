package com.example;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class switch_windows {
    public static void main(String[] args) {
        boolean isHeadless = false; // Change to false if you want to see the browser
        ChromeOptions options = new ChromeOptions();
        if (isHeadless) {

            options.addArguments("--headless=new");
        }

        WebDriver driver = new ChromeDriver(options);
        // driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector(".blinkingText")).click(); // click on the link that opens a new window
        Set<String> windows = driver.getWindowHandles(); // getWindowHandles() returns a set of window handles
        Iterator<String> it = windows.iterator(); // using to iterate through the set of window handles
        String parentID = it.next();
        String childID = it.next();

        driver.switchTo().window(childID); // switch to the child window
        String email_id = driver.findElement(By.cssSelector(".im-para.red")).getText();
        // Please email us at mentor@rahulshettyacademy.com with below template to
        // receive response
        String[] first_split = email_id.split("at");
        String[] second_split = first_split[1].split("with");
        String email = second_split[0].trim(); // trim to remove any leading or trailing spaces
        System.out.println(email);
        driver.switchTo().window(parentID);
        driver.findElement(By.id("username")).sendKeys(email);
        driver.quit();

    }
}
