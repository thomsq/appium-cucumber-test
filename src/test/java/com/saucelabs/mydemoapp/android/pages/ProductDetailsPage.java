package com.saucelabs.mydemoapp.android.pages;

import com.saucelabs.mydemoapp.android.base.BaseDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ProductDetailsPage extends BaseDriver {

    // Locators for product details page
    private final By PRODUCT_TITLE = MobileBy.id("com.saucelabs.mydemoapp.android:id/productTV");
    private final By PRODUCT_TEXT = MobileBy.id("com.saucelabs.mydemoapp.android:id/descTV");
    private final By PRODUCT_PRICE = MobileBy.id("com.saucelabs.mydemoapp.android:id/priceTV");
    private final By PRODUCT_IMAGE = MobileBy.id("com.saucelabs.mydemoapp.android:id/productIV");
    private final By ADD_TO_CART_BUTTON = MobileBy.id("com.saucelabs.mydemoapp.android:id/cartBt");
    private final By PLUS_BUTTON = MobileBy.AccessibilityId("Increase item quantity");
    private final By MINUS_BUTTON = MobileBy.AccessibilityId("Decrease item quantity");
    private final By QUANTITY_COUNTER = MobileBy.id("com.saucelabs.mydemoapp.android:id/noTV");
    private final By COLOR_PICKER = MobileBy.AccessibilityId("Displays available colors of selected product");

    // Color options
    private final By RED_COLOR = MobileBy.AccessibilityId("Red color");
    private final By BLUE_COLOR = MobileBy.AccessibilityId("Blue color");
    private final By BLACK_COLOR = MobileBy.AccessibilityId("Black color");
    private final By GRAY_COLOR = MobileBy.AccessibilityId("Gray color");

    public boolean isProductDetailsPageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_TITLE)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private MobileElement scrollToElement(By locator) {
        String resourceId = locator.toString().split("id: ")[1];
        return (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().resourceId(\"" + resourceId + "\"))"));

    }

    public String getProductTitle() {
        MobileElement titleElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_TITLE));
        return titleElement.getText();
    }

    public String getProductDescription() {
        MobileElement descElement = scrollToElement(PRODUCT_TEXT);
        return descElement.getText();
    }

    public String getProductPrice() {
        MobileElement priceElement = (MobileElement) driver.findElement(PRODUCT_PRICE);
        return priceElement.getText();
    }

    public boolean isProductImageDisplayed() {
        try {
            return driver.findElement(PRODUCT_IMAGE).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void addToCart() {
        MobileElement addToCartButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(ADD_TO_CART_BUTTON));
        addToCartButton.click();
    }

    public void goBackToProducts() {
        driver.navigate().back();
    }

    public void increaseQuantity() {
        MobileElement plusButton = (MobileElement) driver.findElement(PLUS_BUTTON);
        plusButton.click();
    }

    public void decreaseQuantity() {
        MobileElement minusButton = (MobileElement) driver.findElement(MINUS_BUTTON);
        minusButton.click();
    }

    public int getQuantity() {
        MobileElement quantityElement = (MobileElement) driver.findElement(QUANTITY_COUNTER);
        return Integer.parseInt(quantityElement.getText());
    }

    public void selectColor(String color) {
        By colorLocator;
        switch (color.toLowerCase()) {
            case "red":
                colorLocator = RED_COLOR;
                break;
            case "blue":
                colorLocator = BLUE_COLOR;
                break;
            case "black":
                colorLocator = BLACK_COLOR;
                break;
            case "gray":
                colorLocator = GRAY_COLOR;
                break;
            default:
                throw new IllegalArgumentException("Invalid color: " + color);
        }

        MobileElement colorElement = (MobileElement) driver.findElement(colorLocator);
        colorElement.click();
    }

    public boolean isAddToCartButtonEnabled() {
        try {
            MobileElement addToCartButton = (MobileElement) driver.findElement(ADD_TO_CART_BUTTON);
            return addToCartButton.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }
}

