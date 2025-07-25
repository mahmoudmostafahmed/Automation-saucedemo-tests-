package com.Automationtask.saucedemosite.screen;

import org.openqa.selenium.By;

public class CheckoutOverviewPage extends BaseScreen {
    private static final By summaryTotal = By.className("summary_total_label");
    private final By finishBtn = By.id("finish");

    public static boolean isOrderSummaryVisible() {
        return waitUtils.waitUntilElementIsVisible(summaryTotal).isDisplayed();
    }

    public void clickFinish() {
        waitUtils.waitUntilElementIsClickable(finishBtn).click();
    }
}
