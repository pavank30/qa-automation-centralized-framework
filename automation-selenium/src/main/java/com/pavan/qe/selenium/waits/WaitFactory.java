package com.pavan.qe.selenium.waits;

import com.pavan.qe.commons.config.ConfigLoader;
import com.pavan.qe.selenium.driver.DriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class WaitFactory {

    private WaitFactory() {

    }

    public static WebDriverWait explicitWait(){

        int timeout = Integer.parseInt(ConfigLoader.get("timeout_30Secs"));

        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(timeout));
    }
}
