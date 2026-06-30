package com.pavan.qe.selenium.pages;

import com.pavan.qe.selenium.actions.ElementActions;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private static final By userNameTextBox = By.id("user-name");
    private static final By passwordTextBox = By.id("password");
    private static final By loginBtn = By.id("login-button");

    public void enterUsername(String userName) {
        ElementActions.type(userNameTextBox, userName);
        ElementActions.submit(userNameTextBox);
    }

    public void enterPassword(String password) {
        ElementActions.type(passwordTextBox, password);
//        ElementActions.submit(passwordTextBox);
    }

    public void clickLoginButton() {
        ElementActions.click(loginBtn);
    }

    public void login(String userName, String password) {
        enterUsername(userName);
        enterPassword(password);

//        try {
//            Thread.sleep(30000); // Wait for 3 seconds before clicking the login button
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        clickLoginButton();
    }
}
