package com.pavan.qe.selenium.tests;

import com.pavan.qe.selenium.base.BaseTest;
import com.pavan.qe.selenium.pages.HomePage;
import com.pavan.qe.selenium.pages.LoginPage;
import com.pavan.qe.selenium.waits.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin() {
        LoginPage loginPage = new LoginPage();
        loginPage.login("standard_user", "secret_sauce");
//        WaitUtils.threadSleep(10);

        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isAppLogoDisplayed(), "User is not on Home Page");
        Assert.fail("Failing intentionaly");

    }

}
