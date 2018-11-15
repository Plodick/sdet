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
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.concurrent.TimeUnit;

public class SecondTest {
    private static WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void copyTest() throws java.awt.datatransfer.UnsupportedFlavorException, java.io.IOException {
        driver.get("https://clipboardjs.com/");

        WebElement copyButton = driver.findElement(By.xpath("//span[@class='input-group-button']/button[@class='btn']"));
        copyButton.click();

        WebElement textField = driver.findElement(By.xpath("//input[@id='foo']"));
        String string1 = textField.getAttribute("value");

        Transferable trans = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        String string2 = (String) trans.getTransferData(DataFlavor.stringFlavor);

        Assert.assertEquals(string1, string2);
    }

    @Test
    public void copyPastTest() {
        driver.get("https://google.com/");

        WebElement searchInputElement = driver.findElement(By.id("lst-ib"));

        String string1 = "This text will be copied into clipboard when running this code!";
        StringSelection stringSelection = new StringSelection(string1);
        Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipBoard.setContents(stringSelection, null);

        searchInputElement.sendKeys(Keys.CONTROL + "v");

        String string2 = searchInputElement.getAttribute("value");

        Assert.assertEquals(string1, string2);
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
