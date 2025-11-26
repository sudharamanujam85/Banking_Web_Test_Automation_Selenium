package com.example.banking.pages;

import org.openqa.selenium.*;
import io.qameta.allure.Step;

public class LoginPage {
    private final WebDriver driver;

    private final By username = By.name("username");
    private final By password = By.name("password");
    private final By loginBtn = By.xpath("//input[@value='Log In']");

    public LoginPage(WebDriver d){ this.driver=d; }

    @Step("Login as {0}")
    public DashboardPage login(String user, String pass){
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
        return new DashboardPage(driver);
    }
}
