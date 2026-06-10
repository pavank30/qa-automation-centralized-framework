package com.pavan.qe.selenium.enums;

public enum BrowserType {

    CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge"),
    SAFARI("safari");

    private final String value;

    BrowserType(String value) {
        this.value = value;
    }

    public String getvalue() {
        return value;
    }

    public static BrowserType from(String browser) {
        for (BrowserType browserType: values()) {
            if (browserType.getvalue().equalsIgnoreCase(browser)) {
                return browserType;
            }
        }
        throw new IllegalArgumentException("Unsupported browser type: " + browser);
    }
}
