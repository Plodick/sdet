package com.simbirsoft.qaa.course.task4;

import com.simbirsoft.qaa.course.task2.helpers.ClipboardHelper;
import com.simbirsoft.qaa.course.task2.pageobjects.ClipboardJsPage;
import com.simbirsoft.qaa.course.task2.pageobjects.GoogleMainPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.net.MalformedURLException;

public class CopyPasteTestsGrid {

    @BeforeMethod
    public void beforeMethod() throws MalformedURLException {
        TLRemoteDriverFactory.setTlDriver();
    }

    @Test
    public void copyButtonTest() throws UnsupportedFlavorException, IOException {
        TLRemoteDriverFactory.getTLDriver().get("https://clipboardjs.com/");
        ClipboardJsPage clipboardJsPage = new ClipboardJsPage(TLRemoteDriverFactory.getTLDriver());
        String fieldText = clipboardJsPage
                .clickCopyButton()
                .getTextFromField();
        Assert.assertEquals(fieldText, ClipboardHelper.getStringFromClipboard());
    }

    @Test
    public void pasteFromClipboardTest() {
        TLRemoteDriverFactory.getTLDriver().get("https://google.com/");
        GoogleMainPage googleMainPage = new GoogleMainPage(TLRemoteDriverFactory.getTLDriver());
        String clipboardText = "This text will be copied into clipboard when running this code!";
        ClipboardHelper.setStringToClipboard(clipboardText);
        String fieldText = googleMainPage
                .pasteToSearchFieldFromClipboard()
                .getTextFromSearchField();
        Assert.assertEquals(fieldText, clipboardText);
    }

    @AfterMethod
    public void afterMethod() {
        TLRemoteDriverFactory.getTLDriver().quit();
    }
}
