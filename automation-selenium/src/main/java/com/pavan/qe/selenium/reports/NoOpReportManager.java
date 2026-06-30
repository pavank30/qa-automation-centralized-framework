package com.pavan.qe.selenium.reports;

public class NoOpReportManager implements ReportManager {

    @Override
    public void startTest(String testName) {
    }

    @Override
    public void pass(String message) {
    }

    @Override
    public void fail(String message) {
    }

    @Override
    public void skip(String message) {
    }

    @Override
    public void flush() {
    }
}