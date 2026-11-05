
package com.pavan.qe.selenium.driver;

import com.pavan.qe.commons.exceptions.DriverException;
import com.pavan.qe.selenium.config.SeleniumExecutionConfig;
import com.pavan.qe.selenium.enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public final class DriverFactory {

    private DriverFactory() {
        // Prevent instantiation
    }

    public static WebDriver createDriver(SeleniumExecutionConfig config) {

        BrowserType browserType = config.getBrowser();

        return switch (browserType) {
            case CHROME -> createChromeDriver();
            case FIREFOX -> createFirefoxDriver();
            case EDGE -> createEdgeDriver();
            case SAFARI -> throw new DriverException(
                    "Safari browser is not supported yet."
            );
        };
    }

    private static WebDriver createChromeDriver() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        prefs.put("autofill.profile_enabled", false);
        prefs.put("autofill.credit_card_enabled", false);

        options.setExperimentalOption("prefs", prefs);

        return new ChromeDriver(options);
    }

    private static WebDriver createFirefoxDriver() {

        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions();

        return new FirefoxDriver(options);
    }

    private static WebDriver createEdgeDriver() {

        WebDriverManager.edgedriver().setup();

        EdgeOptions options = new EdgeOptions();

        return new EdgeDriver(options);
    }
}
