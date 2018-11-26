package com.simbirsoft.qaa.course.task4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TLDriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public synchronized static void setTlDriver() {
        tlDriver = ThreadLocal.withInitial(ChromeDriver::new);
    }

    public synchronized static WebDriver getTLDriver() {
        return tlDriver.get();
    }
}
