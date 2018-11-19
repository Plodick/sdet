package com.simbirsoft.qaa.course.task1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstTest {

    private static WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void searchTest() {

        WebElement searchInputElement = driver.findElement(By.id("lst-ib"));
        searchInputElement.sendKeys("Автоматизация тестирования");

        WebElement searchButtonElement = driver.findElement(By.cssSelector("input[value='Поиск в Google']"));
        searchButtonElement.click();

        List<WebElement> searchResultsElements = driver.findElements(By.cssSelector("div#search div[data-hveid]"));

        Assert.assertTrue(searchResultsElements.size() > 0, "Не найдено");
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
