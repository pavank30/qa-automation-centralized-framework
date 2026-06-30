package com.pavan.qe.selenium.pages.google;

import com.pavan.qe.selenium.driver.DriverManager;
import com.pavan.qe.selenium.pages.BasePage;

public class GoogleSearchResultsPage extends BasePage {

    public String getPageTitle() {

        return DriverManager.getDriver()
                .getTitle();
    }
}