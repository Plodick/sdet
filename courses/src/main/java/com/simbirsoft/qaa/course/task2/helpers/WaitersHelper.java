package com.simbirsoft.qaa.course.task2.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitersHelper {

    private static long waitTime = 10;

    public static WebElement waitUntilVisibleLocated(WebDriver driver, By selector) {
        return (new WebDriverWait(driver, waitTime))
                .until(ExpectedConditions.visibilityOfElementLocated(selector));
    }

    public static WebElement waitUntilVisible(WebDriver driver, WebElement webElement) {
        return (new WebDriverWait(driver, waitTime))
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public static WebElement waitUntilClickable(WebDriver driver, WebElement webElement) {
        return (new WebDriverWait(driver, waitTime))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
