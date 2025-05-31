package com.Automationtask.saucedemosite.platform;

import com.Automationtask.saucedemosite.screen.*;

public class saucedemo {

    public LoginPage loginPage;
    public BaseScreen baseScreen;
    public InventoryPage inventoryPage;
    public ProductPage productPage;
    public CartPage cartPage;
    public  CheckoutPage CheckoutPage;
    public  CheckoutCompletePage checkoutCompletePage;
    public  CheckoutOverviewPage CheckoutOverviewPage;

    public saucedemo() {


    loginPage = new  LoginPage();
    baseScreen = new BaseScreen();
    CheckoutPage  = new CheckoutPage();
    checkoutCompletePage  = new CheckoutCompletePage();
    CheckoutOverviewPage   = new CheckoutOverviewPage();
    inventoryPage = new InventoryPage();
    productPage = new ProductPage();
    cartPage = new CartPage();
    {

    }

}
}