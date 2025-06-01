package com.Automationtask.saucedemosite.tests;

import com.Automationtask.saucedemosite.screen.*;
import com.Automationtask.saucedemosite.tests.UserDataFetcher;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.Automationtask.saucedemosite.utils.read_properties.ReadProperties.setSauceCorporationConfig;

public class PurchaseTest extends BaseTest {

    String userName = setSauceCorporationConfig().getProperty("userName");
    String password = setSauceCorporationConfig().getProperty("password");

    public PurchaseTest() throws IOException {
    }

    @Test
    public void completePurchaseFlow() throws Exception {
        // Initialize Page Objects
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();
        ProductPage productPage = new ProductPage();
        CartPage cartPage = new CartPage();
        CheckoutPage checkoutPage = new CheckoutPage();
        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage();
        CheckoutCompletePage completePage = new CheckoutCompletePage();

        browser.SauceDemo.loginPage.enterUsername(userName)
                .enterPassword(password)
                .clickOnSubmitButton();

        inventoryPage.addFleeceJacketToCart();
        inventoryPage.openOnesieDetails();
        productPage.addToCart();
        productPage.goBackToInventory();
        Assert.assertEquals(inventoryPage.getCartBadgeCount(), "2", "Cart badge count mismatch");
        inventoryPage.goToCart();
        Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Fleece Jacket"), "Fleece Jacket not in cart");
        Assert.assertTrue(cartPage.isProductInCart("Sauce Labs Onesie"), "Onesie not in cart");
        cartPage.clickCheckout();
        String[] userData = UserDataFetcher.fetchRandomUserData();
        checkoutPage.enterFirstName(userData[0])
                .enterLastName(userData[1])
                .enterPostalCode(userData[2])
                .clickContinue();
        Assert.assertTrue(overviewPage.isOrderSummaryVisible(), "Order summary is not visible");
        overviewPage.clickFinish();
        Assert.assertTrue(completePage.isOrderCompleteMessageVisible(), "Order completion message not visible");
    }
}
