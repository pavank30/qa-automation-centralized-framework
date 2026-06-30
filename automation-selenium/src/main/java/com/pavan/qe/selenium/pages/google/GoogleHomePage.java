package com.pavan.qe.selenium.pages.google;

import com.pavan.qe.selenium.actions.ElementActions;
import com.pavan.qe.selenium.pages.BasePage;
import org.openqa.selenium.By;

public class GoogleHomePage extends BasePage {

    private static final By SEARCH_BOX =
            By.id("APjFqb");

    public GoogleHomePage search(String keyword) {

        ElementActions.type(SEARCH_BOX, keyword);
        ElementActions.submit(SEARCH_BOX);
        return this;
    }
}