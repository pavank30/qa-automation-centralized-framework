package com.pavan.qe.selenium.reports;

public interface ReportManager {

    void startTest(String testName);

    void pass(String message);

    void fail(String message);

    void skip(String message);

    void flush();
}