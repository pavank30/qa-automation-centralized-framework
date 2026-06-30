package com.pavan.qe.selenium.pages;

import com.pavan.qe.selenium.actions.ElementActions;
import org.openqa.selenium.By;

public class GoogleHomePage extends BasePage {

    private static final By SEARCH_BOX = By.name("q");

    public void search(String keyword) {
        ElementActions.type(SEARCH_BOX, keyword);
    }
}
