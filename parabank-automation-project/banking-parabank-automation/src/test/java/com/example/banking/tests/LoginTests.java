package com.example.banking.tests;

import com.example.banking.core.BaseTest;
import com.example.banking.pages.*;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTests extends BaseTest {

    @Test
    public void loginTest(){
        LoginPage lp = new LoginPage(driver);
        DashboardPage dp = lp.login("john", "demo");
        assertThat(dp.isLoaded()).isTrue();
    }
}
