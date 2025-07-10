package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class ScreenshotExample {
    public static void main(String[] args) {
        // Set path to EdgeDriver executable if needed

        WebDriver driver = new EdgeDriver();
        driver.get("https://google.com");

        // Take screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Save screenshot
        try {
            FileUtils.copyFile(screenshot, new File("C:\\Work\\screenshot.png"));
            System.out.println("Screenshot taken!");
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }

        driver.quit();
    }
}
