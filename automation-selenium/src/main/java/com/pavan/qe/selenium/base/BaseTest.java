package com.pavan.qe.selenium.base;

import com.pavan.qe.commons.config.ConfigLoader;
import com.pavan.qe.commons.context.FrameworkContext;
import com.pavan.qe.selenium.driver.DriverFactory;
import com.pavan.qe.selenium.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        String browser = System.getProperty("browser", ConfigLoader.get("browser"));
        FrameworkContext.initialize(browser, "web");

        WebDriver driver = DriverFactory.createDriver();
        DriverManager.setDriver(driver);

        driver.get(ConfigLoader.get("base.url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){

        try {
            log.info("Closing the browser and quitting the WebDriver.");
            DriverManager.getDriver().quit();
        } finally {

            DriverManager.unload();
            FrameworkContext.clear();
        }
    }
}
