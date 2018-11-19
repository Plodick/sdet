package com.simbirsoft.qaa.course.task2.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClipboardJsPage {

    private WebDriver driver;
    @FindBy(xpath = "//span[@class='input-group-button']")
    private WebElement copyButton;
    @FindBy(xpath = "//input[@id='foo']")
    private WebElement textField;

    public ClipboardJsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ClipboardJsPage clickCopyButton() {
        copyButton.click();
        return this;
    }

    public String getTextFromField() {
        return textField.getAttribute("value");
    }
}
