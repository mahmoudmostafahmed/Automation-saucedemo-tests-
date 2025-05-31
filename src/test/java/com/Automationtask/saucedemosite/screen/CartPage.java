package com.Automationtask.saucedemosite.screen;

import org.openqa.selenium.By;

public class CartPage extends BaseScreen {
    private final By checkoutBtn = By.id("checkout");

    public boolean isProductInCart(String productName) {
        By productLocator = By.xpath("//div[text()='" + productName + "']");
        return waitUtils.waitUntilElementIsVisible(productLocator).isDisplayed();
    }

    public void clickCheckout() {
        waitUtils.waitUntilElementIsClickable(checkoutBtn).click();
    }
}
