package com.pavan.qe.selenium.pages;

import com.pavan.qe.selenium.driver.DriverManager;
import com.pavan.qe.selenium.waits.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    private static final By appLogo = By.className("app_logo");

    public boolean isAppLogoDisplayed() {
        return WaitUtils.waitForVisible(appLogo).isDisplayed();
    }
}
