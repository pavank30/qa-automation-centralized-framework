package com.pavan.qe.selenium.listeners;

import com.pavan.qe.commons.logging.LoggerManager;
import com.pavan.qe.selenium.utils.ScreenshotUtils;
import org.slf4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final Logger log =
            LoggerManager.getLogger(TestListener.class);

    @Override
    public void onStart(ITestContext context) {

        log.info("===== Test Execution Started =====");
    }

    @Override
    public void onFinish(ITestContext context) {

        log.info("===== Test Execution Finished =====");
    }

    @Override
    public void onTestStart(ITestResult result) {

        log.info("STARTED : {}", result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        log.info("PASSED : {}", result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        log.error("FAILED : {}", result.getMethod().getMethodName());

        try {
            String screenshotPath =
                    ScreenshotUtils.capture(
                            result.getMethod().getMethodName()
                    );

            log.error("Screenshot : {}", screenshotPath);

        } catch (Exception e) {
            log.error("Screenshot capture failed.", e);
        }

        if (result.getThrowable() != null) {
            log.error("Failure Reason", result.getThrowable());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        log.warn("SKIPPED : {}", result.getMethod().getMethodName());
    }
}