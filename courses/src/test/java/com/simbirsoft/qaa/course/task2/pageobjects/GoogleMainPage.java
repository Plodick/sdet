package com.simbirsoft.qaa.course.task2.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleMainPage {

    private WebDriverWait wait;

    private WebDriver driver;

    private By searchInputSelector = By.xpath("//input[@title='Поиск']");

    public GoogleMainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public GoogleMainPage pasteToSearchField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInputSelector))
                .sendKeys(Keys.CONTROL, "v");
        return this;
    }

    public String getTextFromSearchField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchInputSelector))
                .getAttribute("value");
    }

}
