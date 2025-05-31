package com.Automationtask.saucedemosite.screen;

import org.openqa.selenium.By;

public class CheckoutCompletePage extends BaseScreen {
    private final By completeMessage = By.className("complete-header");

    public boolean isOrderCompleteMessageVisible() {
        return waitUtils.waitUntilElementIsVisible(completeMessage).isDisplayed();
    }
}
