package com.Automationtask.saucedemosite.tests;

import com.Automationtask.saucedemosite.browser.Browser;
import com.Automationtask.saucedemosite.driver.Driver;
import com.Automationtask.saucedemosite.utils.read_properties.ReadProperties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;


public class BaseTest {
    protected static Browser browser;

    static {
        try {
            browser = new Browser();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedFlavorException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getBrowserName() throws IOException {
        return ReadProperties.setSauceCorporationConfig().getProperty("browserName");
    }

    @BeforeMethod(alwaysRun = true)
    protected void setUp() throws IOException {
        Driver.initDriver(getBrowserName());
        Driver.setBrowserResolution();
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown() {
        Driver.closeDriver();
    }

}

