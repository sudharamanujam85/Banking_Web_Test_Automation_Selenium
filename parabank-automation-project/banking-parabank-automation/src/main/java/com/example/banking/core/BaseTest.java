package com.example.banking.core;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        DriverFactory.init();
        driver = DriverFactory.get();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @AfterMethod
    public void teardown() {
        DriverFactory.quit();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}
