package com.simbirsoft.qaa.course.task2.pageobjects;

import com.simbirsoft.qaa.course.task2.helpers.WaitersHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleMainPage {

    private WebDriver driver;

    private By searchInputSelector = By.xpath("//input[@type='text']");

    public GoogleMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public GoogleMainPage pasteToSearchFieldFromClipboard() {
        WaitersHelper.waitUntilVisibleLocated(driver, searchInputSelector)
                .sendKeys(Keys.CONTROL+"v");
        return this;
    }

    public String getTextFromSearchField() {
        return WaitersHelper.waitUntilVisibleLocated(driver, searchInputSelector)
                .getAttribute("value");
    }

}
