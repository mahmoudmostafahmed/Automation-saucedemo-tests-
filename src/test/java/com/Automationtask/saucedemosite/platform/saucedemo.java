package com.Automationtask.saucedemosite.platform;

import com.Automationtask.saucedemosite.screen.*;

public class saucedemo {

    public LoginPage loginPage;
    public BaseScreen baseScreen;
    public InventoryPage inventoryPage;
    public ProductPage productPage;
    public CartPage cartPage;
    public  CheckoutPage checkoutPage;
    public  CheckoutCompletePage checkoutCompletePage;
    public  CheckoutOverviewPage checkoutOverviewPage;

    public saucedemo() {


    loginPage = new  LoginPage();
    baseScreen = new BaseScreen();
    checkoutPage  = new CheckoutPage();
    checkoutCompletePage  = new CheckoutCompletePage();
    checkoutOverviewPage   = new CheckoutOverviewPage();
    inventoryPage = new InventoryPage();
    productPage = new ProductPage();
    cartPage = new CartPage();
    {

    }

}
}
