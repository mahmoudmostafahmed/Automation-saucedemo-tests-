package com.Automationtask.saucedemosite.screen;

import org.openqa.selenium.By;

public class CheckoutPage extends BaseScreen {
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");
    private final By continueBtn = By.id("continue");

    public CheckoutPage enterFirstName(String firstName) {
        waitUtils.waitUntilElementIsPresence(firstNameField).sendKeys(firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName) {
        waitUtils.waitUntilElementIsPresence(lastNameField).sendKeys(lastName);
        return this;
    }

    public CheckoutPage enterPostalCode(String postalCode) {
        waitUtils.waitUntilElementIsPresence(postalCodeField).sendKeys(postalCode);
        return this;
    }

    public void clickContinue() {
        waitUtils.waitUntilElementIsClickable(continueBtn).click();
    }
}
