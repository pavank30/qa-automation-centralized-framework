package com.pavan.qe.selenium.tests;

import com.pavan.qe.selenium.base.BaseTest;
import com.pavan.qe.selenium.driver.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

    @Test
    public void shouldOpenGoogle() {
        Assert.assertEquals(DriverManager.getDriver().getTitle(), "Google");
    }
}
