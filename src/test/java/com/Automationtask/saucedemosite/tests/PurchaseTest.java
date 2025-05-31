package com.Automationtask.saucedemosite.tests;

import com.Automationtask.saucedemosite.screen.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {

    @Test
    public void completePurchaseFlow() throws Exception {
     
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickOnSubmitButton();

       
        InventoryPage inventoryPage = new InventoryPage();
        inventoryPage.addFleeceJacketToCart();

        
        inventoryPage.openOnesieDetails();
        ProductPage detailPage = new ProductPage();
        detailPage.addToCart();
        detailPage.goBackToInventory();

 
        Assert.assertEquals(inventoryPage.getCartBadgeCount(), "2");

 
        inventoryPage.goToCart();
        CartPage cartPage = new CartPage();
        Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Fleece Jacket"));
        Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Onesie"));
        cartPage.clickCheckout();

     
        String[] userData = UserDataFetcher.fetchRandomUserData();
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.enterFirstName(userData[0])
                .enterLastName(userData[1])
                .enterPostalCode(userData[2])
                .clickContinue();

        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage();
        Assert.assertTrue(overviewPage.isOrderSummaryVisible());
        overviewPage.clickFinish();

      
        CheckoutCompletePage completePage = new CheckoutCompletePage();
        Assert.assertTrue(completePage.isOrderCompleteMessageVisible());
    }
}
