package com.example.banking.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static void init() {
        WebDriverManager.chromedriver().setup();
        WebDriver d = new ChromeDriver();
        d.manage().window().maximize();
        DRIVER.set(d);
    }

    public static WebDriver get() { return DRIVER.get(); }

    public static void quit() {
        if (DRIVER.get() != null) {
            DRIVER.get().quit();
            DRIVER.remove();
        }
    }
}
