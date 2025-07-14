package com.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.asserts.SoftAssert;

public class broken_links {
    public static void main(String[] args) throws MalformedURLException, IOException {
        boolean headless = true;
        EdgeOptions options = new EdgeOptions();
        if (headless) {
            options.addArguments("--headless");
            options.setAcceptInsecureCerts(true);
        }
        WebDriver driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> links = driver.findElements(By.cssSelector("li[class*='gf-li'] a"));
        SoftAssert soft = new SoftAssert();

        for (WebElement link : links) {

            String url_link = link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url_link).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int responseCode = conn.getResponseCode();
            System.out.println(responseCode + " " + link.getText());
            soft.assertTrue(responseCode < 400, link.getText() + " is a broken link " + responseCode);

        }
        soft.assertAll();

        driver.quit();

    }

}
