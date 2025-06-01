package com.Automationtask.saucedemosite.tests;

import com.Automationtask.saucedemosite.platform.saucedemo;
import com.Automationtask.saucedemosite.screen.*;
import com.Automationtask.saucedemosite.tests.UserDataFetcher;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.Automationtask.saucedemosite.utils.read_properties.ReadProperties.setSauceCorporationConfig;

public class PurchaseTest extends BaseTest {

    String userName = setSauceCorporationConfig().getProperty("userName");
    String password = setSauceCorporationConfig().getProperty("password");
    saucedemo SauceDemoPages =new saucedemo();


    public PurchaseTest() throws IOException {
    }

    @Test
    public void completePurchaseFlow() throws Exception {

        browser.SauceDemo.loginPage.enterUsername(userName)
                .enterPassword(password)
                .clickOnSubmitButton();

        SauceDemoPages.inventoryPage.addFleeceJacketToCart();
        SauceDemoPages.inventoryPage.openOnesieDetails();
        SauceDemoPages. productPage.addToCart();
        SauceDemoPages. productPage.goBackToInventory();
        Assert.assertEquals(SauceDemoPages.inventoryPage.getCartBadgeCount(), "2", "Cart badge count mismatch");
        SauceDemoPages. inventoryPage.goToCart();
        Assert.assertTrue(SauceDemoPages.cartPage.isProductInCart("Sauce Labs Fleece Jacket"), "Fleece Jacket not in cart");
        Assert.assertTrue(SauceDemoPages.cartPage.isProductInCart("Sauce Labs Onesie"), "Onesie not in cart");
        SauceDemoPages.cartPage.clickCheckout();
        String[] userData = UserDataFetcher.fetchRandomUserData();
        SauceDemoPages.checkoutPage.enterFirstName(userData[0])
                .enterLastName(userData[1])
                .enterPostalCode(userData[2])
                .clickContinue();
        Assert.assertTrue(CheckoutOverviewPage.isOrderSummaryVisible(), "Order summary is not visible");
        SauceDemoPages.checkoutOverviewPage.clickFinish();
        Assert.assertTrue(SauceDemoPages.checkoutCompletePage.isOrderCompleteMessageVisible(), "Order completion message not visible");
    }
}
