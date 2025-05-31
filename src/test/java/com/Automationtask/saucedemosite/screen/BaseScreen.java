package com.Automationtask.saucedemosite.screen;

import com.Automationtask.saucedemosite.driver.DriverManager;
import com.Automationtask.saucedemosite.waits.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class BaseScreen {
    protected final WaitUtils waitUtils = new WaitUtils();
    protected Actions actions;
    protected JavascriptExecutor executor;

    protected String constructXpath(String xpath, String replacingStr) {
        return String.format(xpath, replacingStr);
    }

    protected WebElement getWebElement(By by) {
        return waitUtils.waitUntilElementIsVisible(by);
    }

    public List<WebElement> getElements(By selector) {
        waitUtils.waitUntilElementIsVisible(selector);
        return DriverManager.getWebDriver().findElements(selector);
    }

    public void scrollToElement(By selector) {
        WebElement element = getWebElement(selector);
        actions = new Actions(DriverManager.getWebDriver());
        ((JavascriptExecutor) DriverManager.getWebDriver())
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public String getCurrentUrl() {
        return DriverManager.getWebDriver().getCurrentUrl();
    }

    public void assertItemIsSelected(By by, boolean shouldBeChecked) {
        WebElement item = waitUtils.waitUntilElementIsPresence(by);
        boolean isChecked = item.isSelected();
        Assert.assertEquals(isChecked, shouldBeChecked);
    }
}
