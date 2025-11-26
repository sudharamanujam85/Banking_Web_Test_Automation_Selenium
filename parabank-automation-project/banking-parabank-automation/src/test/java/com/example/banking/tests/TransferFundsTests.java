package com.example.banking.tests;

import com.example.banking.core.BaseTest;
import com.example.banking.pages.*;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TransferFundsTests extends BaseTest {

    @Test
    public void transferFundsTest(){
        DashboardPage dp = new LoginPage(driver).login("john","demo");
        TransferFundsPage tf = dp.goToTransferFunds();
        tf.transfer("200","12345","54321");
        assertThat(tf.isSuccess()).isTrue();
    }
}
