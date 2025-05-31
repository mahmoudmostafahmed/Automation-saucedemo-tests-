package com.Automationtask.saucedemosite.screen;

import org.openqa.selenium.By;

public class LoginPage extends BaseScreen {
    private final By userNameText = By.id("user-name");
    private final By passwordText = By.id("password");
    private final By submitButton = By.id("login-button");


    public LoginPage enterUsername(String username) {
        waitUtils.waitUntilElementIsPresence(userNameText).clear();
        waitUtils.waitUntilElementIsPresence(userNameText).sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        waitUtils.waitUntilElementIsPresence(passwordText).clear();
        waitUtils.waitUntilElementIsPresence(passwordText).sendKeys(password);
        return this;
    }

    public String getUrl() {
        return getCurrentUrl();
    }



    public void clickOnSubmitButton() {
        waitUtils.waitUntilElementIsClickable(submitButton).click();
         }

    public By getUserNameInput() {
        return userNameText;
    }

    public By getPasswordInput() {
        return passwordText;
    }

    public By getLoginButton() {
        return submitButton;
    }
}
