package com.Automationtask.saucedemosite.waits;

import com.Automationtask.saucedemosite.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    long waitTime = 35;

    public WebElement waitUntilElementIsPresence(By by) {
        if (by == null) {
            throw new IllegalArgumentException("Input must be set");
        }
        return new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(waitTime))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitUntilElementIsClickable(By by) {
        return new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(waitTime))
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement waitUntilElementIsVisible(By by) {
        if (by == null) {
            throw new IllegalArgumentException("Input must be set");
        }
        return new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(waitTime))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void sleep(final long millis) throws InterruptedException {
        Thread.sleep(millis);
    }
}
