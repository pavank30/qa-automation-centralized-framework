
package com.pavan.qe.selenium.waits;

import com.pavan.qe.selenium.config.SeleniumExecutionConfig;
import com.pavan.qe.selenium.driver.DriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class WaitFactory {

    private WaitFactory() {
        // Prevent instantiation
    }

    public static WebDriverWait explicitWait() {

        SeleniumExecutionConfig config =
                SeleniumExecutionConfig.load();

        return new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(config.getExplicitWait())
        );
    }
}
