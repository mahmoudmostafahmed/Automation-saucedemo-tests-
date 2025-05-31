package com.Automationtask.saucedemosite.screen;

import org.openqa.selenium.By;

public class ProductPage extends BaseScreen {
    private final By addToCartBtn = By.cssSelector(".btn_inventory");
    private final By backToProductsBtn = By.id("back-to-products");

    public void addToCart() {
        waitUtils.waitUntilElementIsClickable(addToCartBtn).click();
    }

    public void goBackToInventory() {
        waitUtils.waitUntilElementIsClickable(backToProductsBtn).click();
    }
}
