package com.example.banking.pages;

import org.openqa.selenium.*;
import io.qameta.allure.Step;

public class TransactionsPage {
    private final WebDriver driver;
    private final By table = By.id("accountTable");

    public TransactionsPage(WebDriver d){ this.driver=d; }

    @Step("Check accounts overview visible")
    public boolean isVisible(){
        return driver.findElement(table).isDisplayed();
    }
}
