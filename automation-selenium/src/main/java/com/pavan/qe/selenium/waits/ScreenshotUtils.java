
package com.pavan.qe.selenium.utils;

import com.pavan.qe.selenium.driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ScreenshotUtils {

    private static final String SCREENSHOT_DIRECTORY = "screenshots";

    private static final DateTimeFormatter TIMESTAMP_FORMAT =
            DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS");

    private ScreenshotUtils() {
        // Prevent instantiation
    }

    public static String capture(String testName) {

        try {
            WebDriver driver = DriverManager.getDriver();

            if (!(driver instanceof TakesScreenshot)) {
                throw new IllegalStateException(
                        "Current WebDriver does not support screenshots."
                );
            }

            String timestamp = LocalDateTime.now()
                    .format(TIMESTAMP_FORMAT);

            String fileName = testName + "_" + timestamp + ".png";

            File screenshotDirectory = new File(SCREENSHOT_DIRECTORY);

            FileUtils.forceMkdir(screenshotDirectory);

            File destinationFile =
                    new File(screenshotDirectory, fileName);

            File sourceFile =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(sourceFile, destinationFile);

            return destinationFile.getAbsolutePath();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Unable to capture screenshot for test: " + testName,
                    e
            );
        }
    }
}
