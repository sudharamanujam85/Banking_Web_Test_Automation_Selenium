package com.example.banking.tests;

import com.example.banking.core.BaseTest;
import com.example.banking.pages.*;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TransactionsTests extends BaseTest {

    @Test
    public void transactionsVisibleTest(){
        DashboardPage dp = new LoginPage(driver).login("john","demo");
        TransactionsPage tp = dp.goToTransactions();
        assertThat(tp.isVisible()).isTrue();
    }
}
