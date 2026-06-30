package com.pavan.qe.selenium.actions;

import com.pavan.qe.selenium.waits.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public final class ElementActions {

    private ElementActions() {

    }

    /**
     * Click element.
     */
    public static void click(By locator) {
        WaitUtils.waitForClickable(locator).click();
    }


    /**
     * Type text into element.
     */
    public static void type(By locator, String text) {

        WebElement element =
                WaitUtils.waitForVisible(locator);

        element.clear();
        element.sendKeys(text);
    }

    /**
     * Clear text field.
     */
    public static void clear(By locator) {

        WaitUtils.waitForVisible(locator)
                .clear();
    }

    /**
     * Get text from element.
     */
    public static String getText(By locator) {

        return WaitUtils.waitForVisible(locator)
                .getText();
    }

    /**
     * Check if element is displayed.
     */
    public static boolean isDisplayed(By locator) {

        return WaitUtils.waitForVisible(locator)
                .isDisplayed();
    }

    /**
     * Check if element is enabled.
     */
    public static boolean isEnabled(By locator) {

        return WaitUtils.waitForVisible(locator)
                .isEnabled();
    }

    /**
     * Get attribute value.
     */
    public static String getAttribute(
            By locator,
            String attributeName) {

        return WaitUtils.waitForVisible(locator)
                .getAttribute(attributeName);
    }

    /**
     * Submit form.
     */
    public static void submit(By locator) {

        WaitUtils.waitForVisible(locator)
                .submit();
    }
}
