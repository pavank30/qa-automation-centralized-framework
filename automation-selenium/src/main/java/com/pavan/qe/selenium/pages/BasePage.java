package com.pavan.qe.selenium.pages;

import com.pavan.qe.selenium.driver.DriverManager;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected final WebDriver driver;

    protected BasePage() {
        this.driver = DriverManager.getDriver();
    }
}
