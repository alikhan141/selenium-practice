package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class htmlcert {
    public static void main(String[] args) {

        boolean headless = false;
        EdgeOptions options = new EdgeOptions();
        if (headless) {
            options.addArguments("--headless");
            options.setAcceptInsecureCerts(true);
        }
        WebDriver driver = new EdgeDriver(options);
        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();
        driver.get("https://expired.badssl.com/");
        driver.quit();

    }
}
