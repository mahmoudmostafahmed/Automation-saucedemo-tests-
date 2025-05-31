package com.Automationtask.saucedemosite.tests;

import org.testng.annotations.Test;

import java.io.IOException;

import static com.Automationtask.saucedemosite.utils.read_properties.ReadProperties.setSauceCorporationConfig;
import static com.Automationtask.saucedemosite.utils.read_properties.ReadProperties.setSauceCorporationConfig;
import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    String userName = setSauceCorporationConfig().getProperty("userName");
    String password = setSauceCorporationConfig().getProperty("password");
      String url = setSauceCorporationConfig().getProperty("URL");

    public LoginTest() throws IOException {
    }

    @Test
    public void loginTestCaseValidUserNameAndValidPassword() {
        browser.ultimaViewer.loginPage.enterUsername(userName)
                .enterPassword(password)
                .clickOnSubmitButton();
        assertEquals(browser.ultimaViewer.loginPage.getUrl(), url );
    }


}