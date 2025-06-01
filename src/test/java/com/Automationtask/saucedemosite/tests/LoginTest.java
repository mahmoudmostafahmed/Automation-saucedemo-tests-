package com.Automationtask.saucedemosite.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Properties;

import static com.Automationtask.saucedemosite.utils.read_properties.ReadProperties.setSauceCorporationConfig;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    private String userName;
    private String password;
    private String expectedUrl;

    @BeforeClass
    public void setupConfig() {
        try {
            Properties config = setSauceCorporationConfig();
            this.userName = config.getProperty("userName");
            this.password = config.getProperty("password");
            this.expectedUrl = config.getProperty("URL");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration properties", e);
        }
    }

    @Test
    public void shouldLoginSuccessfullyWithValidCredentials() {
        browser.SauceDemo.loginPage.enterUsername(userName)
                .enterPassword(password)
                .clickOnSubmitButton();

        String actualUrl = browser.SauceDemo.loginPage.getUrl();

        assertTrue(actualUrl.contains(expectedUrl),
                "User is not navigated to a URL containing the expected URL after login. " +
                        "Expected to contain: " + expectedUrl + " but was: " + actualUrl);
    }
}
