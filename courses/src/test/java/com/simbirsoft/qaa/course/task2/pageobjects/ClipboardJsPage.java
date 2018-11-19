package com.simbirsoft.qaa.course.task2.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClipboardJsPage {

    private WebDriverWait wait;

    private WebDriver driver;
    @FindBy(xpath = "//span[@class='input-group-button']")
    private WebElement copyButton;
    @FindBy(xpath = "//input[@id='foo']")
    private WebElement textField;

    public ClipboardJsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public ClipboardJsPage clickCopyButton() {
        wait.until(ExpectedConditions.elementToBeClickable(copyButton)).click();
        return this;
    }

    public String getTextFromField() {
        return wait.until(ExpectedConditions.visibilityOf(textField))
                .getAttribute("value");
    }
}
