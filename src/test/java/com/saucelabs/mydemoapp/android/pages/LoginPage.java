package com.saucelabs.mydemoapp.android.pages;

import com.saucelabs.mydemoapp.android.base.BaseDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseDriver {

    // Locators for SauceLabs demo app
    private final By USERNAME_FIELD = MobileBy.id("com.saucelabs.mydemoapp.android:id/nameET");
    private final By PASSWORD_FIELD = MobileBy.id("com.saucelabs.mydemoapp.android:id/passwordET");
    private final By LOGIN_BUTTON = MobileBy.id("com.saucelabs.mydemoapp.android:id/loginBtn");
    private final By ERROR_MESSAGE_PASSWORD = MobileBy.id("com.saucelabs.mydemoapp.android:id/passwordErrorTV") ;
    private final By ERROR_MESSAGE_USERNAME = MobileBy.id("com.saucelabs.mydemoapp.android:id/nameErrorTV");
    private final By MENU_BUTTON = MobileBy.id("com.saucelabs.mydemoapp.android:id/menuIV");
    private final By LOGIN_MENU_ITEM = MobileBy.xpath("//*[@content-desc=\"Recycler view for menu\"]/android.view.ViewGroup[12]/android.widget.TextView");

    public void navigateToLogin() {
        MobileElement menuButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(MENU_BUTTON));
        menuButton.click();

        MobileElement loginMenuItem = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(LOGIN_MENU_ITEM));
        loginMenuItem.click();
    }

    public void enterUsername(String username) {
        MobileElement usernameField = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_FIELD));
        usernameField.click();
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        MobileElement passwordField = (MobileElement) driver.findElement(PASSWORD_FIELD);
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void tapLoginButton() {
        MobileElement loginButton = (MobileElement) driver.findElement(LOGIN_BUTTON);
        loginButton.click();
    }

    public boolean isErrorMessageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE_PASSWORD)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isUsernameErrorMessageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE_USERNAME)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessage() {

        MobileElement errorElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE_PASSWORD));
        return errorElement.getText();
    }

    public String getUsernameErrorMessage() {
        MobileElement errorElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE_USERNAME));
        return errorElement.getText();
    }
}
