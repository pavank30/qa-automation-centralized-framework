
package com.pavan.qe.selenium.config;

import com.pavan.qe.commons.config.ConfigLoader;
import com.pavan.qe.selenium.enums.BrowserType;

public final class SeleniumExecutionConfig {

    private final BrowserType browser;
    private final String baseUrl;
    private final int implicitWait;
    private final int explicitWait;
    private final int pageLoadTimeout;

    private SeleniumExecutionConfig(
            BrowserType browser,
            String baseUrl,
            int implicitWait,
            int explicitWait,
            int pageLoadTimeout) {

        this.browser = browser;
        this.baseUrl = baseUrl;
        this.implicitWait = implicitWait;
        this.explicitWait = explicitWait;
        this.pageLoadTimeout = pageLoadTimeout;
    }

    public static SeleniumExecutionConfig load() {

        String browserValue = System.getProperty(
                "browser",
                ConfigLoader.get("browser", "chrome")
        );

        String baseUrl = ConfigLoader.get("base.url");

        int implicitWait = Integer.parseInt(
                ConfigLoader.get("implicit.wait", "0")
        );

        int explicitWait = Integer.parseInt(
                ConfigLoader.get("explicit.wait", "15")
        );

        int pageLoadTimeout = Integer.parseInt(
                ConfigLoader.get("page.load.timeout", "60")
        );

        return new SeleniumExecutionConfig(
                BrowserType.from(browserValue),
                baseUrl,
                implicitWait,
                explicitWait,
                pageLoadTimeout
        );
    }

    public BrowserType getBrowser() {
        return browser;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public int getImplicitWait() {
        return implicitWait;
    }

    public int getExplicitWait() {
        return explicitWait;
    }

    public int getPageLoadTimeout() {
        return pageLoadTimeout;
    }
}
