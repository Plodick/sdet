package com.simbirsoft.qaa.course.task2.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage {

    private WebDriver driver;

    private By searchInputSelector = By.xpath("//input[@title='Поиск']");

    public GoogleMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public GoogleMainPage pasteToSearchField() {
        driver.findElement(searchInputSelector).sendKeys(Keys.CONTROL,"v");
        return this;
    }

    public String getTextFromSearchField()
    {
        return driver.findElement(searchInputSelector).getAttribute("value");
    }

}
