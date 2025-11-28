package com.saucelabs.mydemoapp.android.pages;

import com.saucelabs.mydemoapp.android.base.BaseDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDetailsPage extends BaseDriver {

    // Locators for product details page
    private final By PRODUCT_TITLE = MobileBy.AccessibilityId("test-Description");
    private final By PRODUCT_TEXT = MobileBy.AccessibilityId("test-desc");
    private final By PRODUCT_PRICE = MobileBy.AccessibilityId("test-Price");
    private final By PRODUCT_IMAGE = MobileBy.AccessibilityId("test-Image Container");
    private final By ADD_TO_CART_BUTTON = MobileBy.AccessibilityId("test-ADD TO CART");
    private final By BACK_BUTTON = MobileBy.AccessibilityId("test-BACK TO PRODUCTS");
    private final By PLUS_BUTTON = MobileBy.AccessibilityId("test-Plus");
    private final By MINUS_BUTTON = MobileBy.AccessibilityId("test-Minus");
    private final By QUANTITY_COUNTER = MobileBy.AccessibilityId("test-Amount");
    private final By COLOR_PICKER = MobileBy.AccessibilityId("test-Color picker");

    // Color options
    private final By RED_COLOR = MobileBy.AccessibilityId("test-red circle");
    private final By BLUE_COLOR = MobileBy.AccessibilityId("test-blue circle");
    private final By BLACK_COLOR = MobileBy.AccessibilityId("test-black circle");
    private final By GRAY_COLOR = MobileBy.AccessibilityId("test-gray circle");

    public boolean isProductDetailsPageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_TITLE)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getProductTitle() {
        MobileElement titleElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_TITLE));
        return titleElement.getText();
    }

    public String getProductDescription() {
        MobileElement descElement = (MobileElement) driver.findElement(PRODUCT_TEXT);
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
        MobileElement backButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(BACK_BUTTON));
        backButton.click();
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

