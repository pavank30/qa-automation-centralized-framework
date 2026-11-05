
package com.pavan.qe.selenium.base;

import com.pavan.qe.commons.context.FrameworkContext;
import com.pavan.qe.commons.enums.FrameworkType;
import com.pavan.qe.selenium.config.SeleniumExecutionConfig;
import com.pavan.qe.selenium.driver.DriverFactory;
import com.pavan.qe.selenium.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    private static final Logger log =
            LoggerFactory.getLogger(BaseTest.class);

    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        // Load Selenium-specific configuration
        SeleniumExecutionConfig config =
                SeleniumExecutionConfig.load();

        // Read common execution environment
        String environment = System.getProperty("env", "qa");

        // Initialize common execution context
        FrameworkContext.initialize(
                FrameworkType.SELENIUM,
                environment,
                "web"
        );

        try {
            // Create and register WebDriver
            WebDriver driver = DriverFactory.createDriver(config);
            DriverManager.setDriver(driver);

            // Configure browser timeouts
            driver.manage().timeouts().implicitlyWait(
                    java.time.Duration.ofSeconds(config.getImplicitWait())
            );

            driver.manage().timeouts().pageLoadTimeout(
                    java.time.Duration.ofSeconds(config.getPageLoadTimeout())
            );

            // Navigate to application URL
            driver.get(config.getBaseUrl());

            log.info(
                    "Selenium execution initialized. Environment: {}, Browser: {}",
                    environment,
                    config.getBrowser()
            );

        } catch (Exception e) {
            log.error("Failed to initialize Selenium execution.", e);

            // Clean up partially initialized execution
            try {
                DriverManager.getDriver().quit();
            } catch (Exception cleanupException) {
                log.warn("WebDriver cleanup failed during setup.", cleanupException);
            } finally {
                DriverManager.unload();
                FrameworkContext.clear();
            }

            throw e;
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        try {
            log.info("Closing the browser and quitting the WebDriver.");

            DriverManager.getDriver().quit();

        } finally {
            DriverManager.unload();
            FrameworkContext.clear();
        }
    }
}
