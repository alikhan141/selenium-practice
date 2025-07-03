package com.example;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class scope_limited {
    public static void main(String[] args) throws InterruptedException {

        EdgeOptions options = new EdgeOptions();
        boolean headless = true;
        if (headless) {
            options.addArguments("--headless");
        }

        WebDriver driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver.findElements(By.tagName("a")).size());
        System.out.println(driver.findElements(By.cssSelector(".gf-t a")).size());

        // one way of getting footer links
        // List<WebElement> footerLinks =
        // footer.findElements(By.xpath("//table/tbody/tr/td[1] /ul /li /a"));
        // System.out.println(footerLinks.size());

        // another way of getting footer links
        WebElement footer = driver.findElement(By.id("gf-BIG"));
        WebElement column_driver = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(column_driver.findElements(By.tagName("a")).size());
        List<WebElement> footerlinks = column_driver.findElements(By.tagName("a"));

        for (int i = 1; i < footerlinks.size(); i++) {
            String clicker = Keys.chord(Keys.CONTROL, Keys.ENTER);
            footerlinks.get(i).sendKeys(clicker);
            Thread.sleep(1000); // Give time for the tab to open
        }

        // Now, after all tabs are open, get all window handles and print their titles
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        while (it.hasNext()) {
            String window = it.next();
            driver.switchTo().window(window);
            System.out.println(driver.getTitle());
        }

        driver.quit();

    }
}
