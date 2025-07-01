package com.example;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment_4 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentID = it.next();
        String childID = it.next();
        driver.switchTo().window(childID);
        System.out.println(driver.findElement(By.tagName("h3")).getText());
        driver.switchTo().window(parentID);
        System.out.println(driver.findElement(By.tagName("h3")).getText());
        driver.quit();
    }
}
