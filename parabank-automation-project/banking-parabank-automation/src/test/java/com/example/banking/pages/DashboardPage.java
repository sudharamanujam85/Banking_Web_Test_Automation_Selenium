package com.example.banking.pages;

import org.openqa.selenium.*;
import io.qameta.allure.Step;

public class DashboardPage {
    private final WebDriver driver;

    private final By accountsOverview = By.linkText("Accounts Overview");
    private final By transferFunds = By.linkText("Transfer Funds");

    public DashboardPage(WebDriver d){ this.driver=d; }

    @Step("Dashboard loaded")
    public boolean isLoaded(){
        return driver.findElement(accountsOverview).isDisplayed();
    }

    public TransactionsPage goToTransactions(){
        driver.findElement(accountsOverview).click();
        return new TransactionsPage(driver);
    }

    public TransferFundsPage goToTransferFunds(){
        driver.findElement(transferFunds).click();
        return new TransferFundsPage(driver);
    }
}
