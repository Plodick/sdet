package com.simbirsoft.qaa.course;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CopyPasteTests {
    private static WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void copyButtonTest() throws UnsupportedFlavorException, IOException {
        driver.get("https://clipboardjs.com/");
        WebElement copyButton = driver.findElement(By.xpath("//button[@data-clipboard-target='foo']"));
        copyButton.click();
        WebElement textField = driver.findElement(By.xpath("//input[@id='foo']"));
        String fieldText = textField.getAttribute("value");
        Transferable trans = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        String clipboardText = (String) trans.getTransferData(DataFlavor.stringFlavor);
        Assert.assertEquals(fieldText, clipboardText);
    }

    @Test
    public void pasteFromClipBoardTest() {
        driver.get("https://google.com/");
        WebElement searchInputElement = driver.findElement(By.id("lst-ib"));
        String clipboardText = "This text will be copied into clipboard when running this code!";
        StringSelection stringSelection = new StringSelection(clipboardText);
        Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipBoard.setContents(stringSelection, null);
        searchInputElement.sendKeys(Keys.CONTROL + "v");
        String fieldText = searchInputElement.getAttribute("value");
        Assert.assertEquals(clipboardText, fieldText);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
