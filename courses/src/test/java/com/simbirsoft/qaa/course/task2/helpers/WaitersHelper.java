package com.simbirsoft.qaa.course.task2.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitersHelper {

    private WebDriverWait wait;

    public WaitersHelper(WebDriver driver) {
        wait = new WebDriverWait(driver, 10);
    }

    public WebElement visibilityOfElementLocated(By selector) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public WebElement visibilityOf(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public WebElement elementToBeClickable(WebElement webElement) {
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
