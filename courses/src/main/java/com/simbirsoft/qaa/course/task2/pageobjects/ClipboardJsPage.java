package com.simbirsoft.qaa.course.task2.pageobjects;

import com.simbirsoft.qaa.course.task2.helpers.WaitersHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClipboardJsPage {

    private WebDriver driver;

    @FindBy(xpath = "//span[@class='input-group-button']")
    @CacheLookup
    private WebElement copyButton;

    @FindBy(xpath = "//input[@id='foo']")
    @CacheLookup
    private WebElement textField;

    public ClipboardJsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ClipboardJsPage clickCopyButton() {
        WaitersHelper.waitUntilClickable(driver, copyButton).click();
        return this;
    }

    public String getTextFromField() {
        return WaitersHelper.waitUntilVisible(driver, textField)
                .getAttribute("value");
    }
}
