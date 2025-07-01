package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class static_dropdown {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");

        // Select only works on the elements that have the <select> tag
       WebElement dropdoWebElement =  driver.findElement(By.cssSelector("select[name*=ListCurrency]"));
        Select dropdown = new Select(dropdoWebElement);
        dropdown.selectByIndex(2);
        System.out.println("Selected currency: " + dropdown.getFirstSelectedOption().getText());
        driver.quit();


    }
}
