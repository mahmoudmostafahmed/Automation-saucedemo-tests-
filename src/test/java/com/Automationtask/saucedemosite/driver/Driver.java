package com.Automationtask.saucedemosite.driver;

import com.Automationtask.saucedemosite.utils.read_properties.ReadProperties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;

public final class Driver {
    private Driver() {
    }

    public static void initDriver(String browserName) throws IOException {
        if (isNull(DriverManager.getWebDriver())) {
            if (browserName.equalsIgnoreCase("chrome")) {
                DriverManager.setWebDriver(new ChromeDriver());
            } else if (browserName.equalsIgnoreCase("edge")) {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--guest");
                edgeOptions.addArguments("--disable-notifications");
                DriverManager.setWebDriver(new EdgeDriver(edgeOptions));
            } else if (browserName.equalsIgnoreCase("firefox")) {
                DriverManager.setWebDriver(new FirefoxDriver());
            } else if (browserName.equalsIgnoreCase("safari")) {
                DriverManager.setWebDriver(new SafariDriver());
            } else if (browserName.equalsIgnoreCase("internetExplorer")) {
                DriverManager.setWebDriver(new InternetExplorerDriver());
            }
            System.out.println(getUrl());
            DriverManager.getWebDriver().navigate().to(getUrl());
        }
    }

    public static void closeDriver() {
        if (DriverManager.getWebDriver() != null) {
            DriverManager.getWebDriver().quit();
            DriverManager.setWebDriver(null);
        }
    }

    public static boolean isNull(Object object) {
        return object == null;
    }

    public static boolean isNotNull(Object object) {
        return object != null;
    }

    public static String getUrl() throws IOException {
        return ReadProperties.setSauceCorporationConfig()
                .getProperty("URL");
    }

    public static void setBrowserResolution() {
        DriverManager.getWebDriver().manage().window().maximize();
    }

    public static int convertStrToInt(String str) {
        return Integer.parseInt(str);
    }

}
