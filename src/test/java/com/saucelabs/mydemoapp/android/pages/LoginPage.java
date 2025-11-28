package com.saucelabs.mydemoapp.android.pages;

import com.saucelabs.mydemoapp.android.base.BaseDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseDriver {

    // Locators for SauceLabs demo app
    private final By USERNAME_FIELD = MobileBy.AccessibilityId("test-Username");
    private final By PASSWORD_FIELD = MobileBy.AccessibilityId("test-Password");
    private final By LOGIN_BUTTON = MobileBy.AccessibilityId("test-LOGIN");
    private final By ERROR_MESSAGE = MobileBy.xpath("//*[@content-desc='test-Error message']");
    private final By MENU_BUTTON = MobileBy.AccessibilityId("test-Menu");
    private final By LOGIN_MENU_ITEM = MobileBy.AccessibilityId("test-Login");

    public void navigateToLogin() {
        MobileElement menuButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(MENU_BUTTON));
        menuButton.click();

        MobileElement loginMenuItem = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(LOGIN_MENU_ITEM));
        loginMenuItem.click();
    }

    public void enterUsername(String username) {
        MobileElement usernameField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_FIELD));
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        MobileElement passwordField = (MobileElement) driver.findElement(PASSWORD_FIELD);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void tapLoginButton() {
        MobileElement loginButton = (MobileElement) driver.findElement(LOGIN_BUTTON);
        loginButton.click();
    }

    public boolean isErrorMessageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessage() {
        MobileElement errorElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE));
        return errorElement.getText();
    }
}
