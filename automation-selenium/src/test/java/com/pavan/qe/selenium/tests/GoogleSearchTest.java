package com.pavan.qe.selenium.tests;

import com.pavan.qe.selenium.base.BaseTest;
import com.pavan.qe.selenium.pages.google.GoogleHomePage;
import com.pavan.qe.selenium.pages.google.GoogleSearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

    @Test
    public void shouldSearchForSelenium() {

        GoogleHomePage homePage =
                new GoogleHomePage();

        homePage.search("Selenium");

        GoogleSearchResultsPage resultsPage =
                new GoogleSearchResultsPage();

        Assert.assertTrue(
                resultsPage.getPageTitle()
                        .contains("Selenium")
        );
    }
}