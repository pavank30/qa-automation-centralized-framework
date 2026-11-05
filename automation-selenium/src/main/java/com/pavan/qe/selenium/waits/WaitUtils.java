package com.pavan.qe.selenium.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public final class WaitUtils {

    private WaitUtils() {

    }

    public static void threadSleep(int time) {

        try {
            Thread.sleep(Duration.ofSeconds(time));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread sleep was interrupted.", e);
        }
    }

    /**
     * Wait until element is visible.
     */
    public static WebElement waitForVisible(By locator) {
        return WaitFactory.explicitWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    /**
     * Wait until element is clickable.
     */
    public static WebElement waitForClickable(By locator) {

        return WaitFactory.explicitWait()
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

//    public static WebElement isDisplayed(By locator) {
//
//        return WaitFactory.explicitWait()
//                .until(ExpectedConditions.elementToBeClickable(locator));
//    }

    /**
     * Wait until element is present in DOM.
     */
    public static WebElement waitForPresence(By locator) {

        return WaitFactory.explicitWait()
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Wait until element disappears.
     */
    public static boolean waitForInvisibility(By locator) {

        return WaitFactory.explicitWait()
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    /**
     * Wait until page title contains text.
     */
    public static boolean waitForTitleContains(String title) {

        return WaitFactory.explicitWait()
                .until(ExpectedConditions.titleContains(title));
    }

    /**
     * Wait until page title is exact match.
     */
    public static boolean waitForTitleIs(String title) {

        return WaitFactory.explicitWait()
                .until(ExpectedConditions.titleIs(title));
    }

    /**
     * Wait until URL contains text.
     */
    public static boolean waitForUrlContains(String urlPart) {

        return WaitFactory.explicitWait()
                .until(ExpectedConditions.urlContains(urlPart));
    }

    /**
     * Wait until URL matches exactly.
     */
    public static boolean waitForUrlToBe(String url) {

        return WaitFactory.explicitWait()
                .until(ExpectedConditions.urlToBe(url));
    }
}

