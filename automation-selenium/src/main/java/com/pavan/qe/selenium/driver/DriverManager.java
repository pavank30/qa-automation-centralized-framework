package com.pavan.qe.selenium.driver;

import com.pavan.qe.commons.exceptions.DriverException;
import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverManager() {
        // Prevent instantiation
    }

    /**
     * Stores WebDriver for current thread.
     */
    public static void setDriver(WebDriver driver)
    {
        DRIVER.set(driver);
    }

    /**
     * Returns WebDriver for current thread.
     */
    public static WebDriver getDriver() {

        WebDriver driver = DRIVER.get();

        if (driver == null) {
            throw new DriverException(
                    "WebDriver is not initialized for current thread."
            );
        }

        return driver;
    }

    /**
     * Removes WebDriver from current thread.
     */
    public static void unload() {
        DRIVER.remove();
    }

}