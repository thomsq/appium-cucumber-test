package com.saucelabs.mydemoapp.android.pages;

import com.saucelabs.mydemoapp.android.base.BaseDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductsPage extends BaseDriver {

    // Locators for products page
    private final By PRODUCTS_TITLE = MobileBy.xpath("//*[@text='Products']");
    private final By PRODUCT_ITEMS = MobileBy.xpath("//*[@content-desc='test-Item']");
    private final By SORT_BUTTON = MobileBy.AccessibilityId("test-Modal Selector Button");
    private final By CART_BUTTON = MobileBy.AccessibilityId("test-Cart");

    // Product item locators (using index-based approach)
    private final String PRODUCT_ITEM_TEMPLATE = "//*[@content-desc='test-Item'][%d]";
    private final String PRODUCT_TITLE_TEMPLATE = "//*[@content-desc='test-Item title'][%d]";
    private final String PRODUCT_PRICE_TEMPLATE = "//*[@content-desc='test-Price'][%d]";

    public boolean isProductsPageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCTS_TITLE)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void selectProduct(int productIndex) {
        By productLocator = MobileBy.xpath(String.format(PRODUCT_ITEM_TEMPLATE, productIndex));
        MobileElement product = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(productLocator));
        product.click();
    }

    public void selectProductByName(String productName) {
        By productLocator = MobileBy.xpath("//*[@content-desc='test-Item title' and @text='" + productName + "']/parent::*");
        MobileElement product = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(productLocator));
        product.click();
    }

    public int getProductCount() {
        @SuppressWarnings("unchecked")
        List<MobileElement> products = driver.findElements(PRODUCT_ITEMS);
        return products.size();
    }

    public String getProductTitle(int productIndex) {
        By titleLocator = MobileBy.xpath(String.format(PRODUCT_TITLE_TEMPLATE, productIndex));
        MobileElement titleElement = (MobileElement) driver.findElement(titleLocator);
        return titleElement.getText();
    }

    public String getProductPrice(int productIndex) {
        By priceLocator = MobileBy.xpath(String.format(PRODUCT_PRICE_TEMPLATE, productIndex));
        MobileElement priceElement = (MobileElement) driver.findElement(priceLocator);
        return priceElement.getText();
    }

    public void openCart() {
        MobileElement cartButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(CART_BUTTON));
        cartButton.click();
    }

    public void openSortOptions() {
        MobileElement sortButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(SORT_BUTTON));
        sortButton.click();
    }
}


