package com.simbirsoft.qaa.course.task2;

import com.simbirsoft.qaa.course.task2.helpers.ClipboardHelper;
import com.simbirsoft.qaa.course.task2.pageobjects.ClipboardJsPage;
import com.simbirsoft.qaa.course.task2.pageobjects.GoogleMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class CopyPasteTests {

    private static WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
    }

    @Test
    public void copyButtonTest() throws UnsupportedFlavorException, IOException {
        driver.get("https://clipboardjs.com/");
        ClipboardJsPage clipboardJsPage = new ClipboardJsPage(driver);
        String fieldText = clipboardJsPage
                .clickCopyButton()
                .getTextFromField();
        Assert.assertEquals(fieldText, ClipboardHelper.getStringFromClipboard());
    }

    @Test
    public void pasteFromClipboardTest() {
        driver.get("https://google.com/");
        GoogleMainPage googleMainPage = new GoogleMainPage(driver);
        String clipboardText = "This text will be copied into clipboard when running this code!";
        ClipboardHelper.setStringToClipboard(clipboardText);
        String fieldText = googleMainPage
                .pasteToSearchFieldFromClipboard()
                .getTextFromSearchField();
        Assert.assertEquals(fieldText, clipboardText);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
