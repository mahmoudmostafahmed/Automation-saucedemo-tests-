package com.Automationtask.saucedemosite.screen;

import org.openqa.selenium.By;

public class InventoryPage extends BaseScreen {
    private final By fleeceJacketAddBtn = By.xpath("//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='inventory_item']//button");
    private final By onesieLink = By.xpath("//div[text()='Sauce Labs Onesie']");
    private final By cartIcon = By.className("shopping_cart_link");
    private final By cartBadge = By.className("shopping_cart_badge");

    public void addFleeceJacketToCart() {
        waitUtils.waitUntilElementIsClickable(fleeceJacketAddBtn).click();
    }

    public void openOnesieDetails() {
        waitUtils.waitUntilElementIsClickable(onesieLink).click();
    }

    public void goToCart() {
        waitUtils.waitUntilElementIsClickable(cartIcon).click();
    }

    public String getCartBadgeCount() {
        return waitUtils.waitUntilElementIsVisible(cartBadge).getText();
    }
}
