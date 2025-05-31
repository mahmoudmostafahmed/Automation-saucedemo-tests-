package com.Automationtask.saucedemosite.tests;

import com.Automationtask.saucedemosite.screen.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {

    @Test
    public void completePurchaseFlow() throws Exception {
        // Step 1: Login
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername("standard_user")
                .enterPassword("secret_sauce")
                .clickOnSubmitButton();

        // Step 2: Add fleece jacket to cart
        InventoryPage inventoryPage = new InventoryPage();
        inventoryPage.addFleeceJacketToCart();

        // Step 3: Open product details and add Onesie
        inventoryPage.openOnesieDetails();
        ProductPage detailPage = new ProductPage();
        detailPage.addToCart();
        detailPage.goBackToInventory();

        // Step 4: Assert cart count
        Assert.assertEquals(inventoryPage.getCartBadgeCount(), "2");

        // Step 5: Go to cart and validate products
        inventoryPage.goToCart();
        CartPage cartPage = new CartPage();
        Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Fleece Jacket"));
        Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Onesie"));
        cartPage.clickCheckout();

        // Step 6: Dynamic checkout using mock API data
        String[] userData = UserDataFetcher.fetchRandomUserData();
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.enterFirstName(userData[0])
                .enterLastName(userData[1])
                .enterPostalCode(userData[2])
                .clickContinue();

        // Step 7: Order overview and complete purchase
        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage();
        Assert.assertTrue(overviewPage.isOrderSummaryVisible());
        overviewPage.clickFinish();

        // Step 8: Complete confirmation
        CheckoutCompletePage completePage = new CheckoutCompletePage();
        Assert.assertTrue(completePage.isOrderCompleteMessageVisible());
    }
}
