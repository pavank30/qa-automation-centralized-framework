package com.pavan.qe.selenium.utils;

import com.pavan.qe.selenium.driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ScreenshotUtils {

    private ScreenshotUtils() {
    }

    public static String capture(String testName) {

        try {

            String timestamp =
                    LocalDateTime.now()
                            .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            String screenshotPath =
                    "screenshots/"
                            + testName
                            + "_"
                            + timestamp
                            + ".png";

            File sourceFile =
                    ((TakesScreenshot) DriverManager.getDriver())
                            .getScreenshotAs(OutputType.FILE);

            File destinationFile = new File(screenshotPath);

            FileUtils.copyFile(sourceFile, destinationFile);

            return destinationFile.getAbsolutePath();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Unable to capture screenshot",
                    e
            );
        }
    }
}