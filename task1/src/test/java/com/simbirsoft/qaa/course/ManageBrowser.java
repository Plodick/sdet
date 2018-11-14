package com.simbirsoft.qaa.course;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManageBrowser {

    private static WebDriver driver;

    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.get("http://www.google.com");

        WebElement searchInputElement = driver.findElement(By.id("lst-ib"));
        searchInputElement.sendKeys("Автоматизация тестирования");

        WebElement searchButtonElement = driver.findElement(By.cssSelector("input[value='Поиск в Google']"));
        searchButtonElement.click();

        driver.quit();
    }
}
