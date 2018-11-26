package com.simbirsoft.qaa.course.task4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class TLRemoteDriverFactory {

    private static ThreadLocal<RemoteWebDriver> remoteDriver = new ThreadLocal<>();

    private static String hubURL = "http://localhost:4448/wd/hub";

    public static void setTlDriver() throws MalformedURLException {
        remoteDriver.set(new RemoteWebDriver(new URL(hubURL), new ChromeOptions()));
    }

    public static WebDriver getTLDriver() {
        return remoteDriver.get();
    }
}
