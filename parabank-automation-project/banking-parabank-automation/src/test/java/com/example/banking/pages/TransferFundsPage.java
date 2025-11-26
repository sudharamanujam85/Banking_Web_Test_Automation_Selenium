package com.example.banking.pages;

import org.openqa.selenium.*;
import io.qameta.allure.Step;

public class TransferFundsPage {
    private final WebDriver driver;

    private final By amount = By.id("amount");
    private final By fromAcc = By.id("fromAccountId");
    private final By toAcc = By.id("toAccountId");
    private final By transferBtn = By.xpath("//input[@value='Transfer']");
    private final By success = By.xpath("//h1[contains(text(),'Transfer Complete')]");

    public TransferFundsPage(WebDriver d){ this.driver=d; }

    @Step("Transfer funds")
    public void transfer(String amt, String from, String to){
        driver.findElement(amount).sendKeys(amt);
        driver.findElement(fromAcc).sendKeys(from);
        driver.findElement(toAcc).sendKeys(to);
        driver.findElement(transferBtn).click();
    }

    public boolean isSuccess(){
        return driver.findElement(success).isDisplayed();
    }
}
