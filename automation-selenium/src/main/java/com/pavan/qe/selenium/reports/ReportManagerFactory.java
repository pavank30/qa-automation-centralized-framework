package com.pavan.qe.selenium.reports;

public final class ReportManagerFactory {

    private static final ReportManager REPORT_MANAGER =
            new NoOpReportManager();

    private ReportManagerFactory() {
    }

    public static ReportManager getReportManager() {

        return REPORT_MANAGER;
    }
}