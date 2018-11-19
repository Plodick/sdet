package com.simbirsoft.qaa.course.task2.pageobjects;

import com.simbirsoft.qaa.course.task2.helpers.WaitersHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleMainPage {

    private WaitersHelper waiter;

    private WebDriver driver;

    private By searchInputSelector = By.xpath("//input[@title='Поиск']");

    public GoogleMainPage(WebDriver driver) {
        this.driver = driver;
        waiter = new WaitersHelper(driver);
    }

    public GoogleMainPage pasteToSearchField() {
        waiter.visibilityOfElementLocated(searchInputSelector)
                .sendKeys(Keys.CONTROL, "v");
        return this;
    }

    public String getTextFromSearchField() {
        return waiter.visibilityOfElementLocated(searchInputSelector)
                .getAttribute("value");
    }

}
