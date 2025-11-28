package com.saucelabs.mydemoapp.android.utils;

import com.saucelabs.mydemoapp.android.base.BaseDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppiumUtils extends BaseDriver {

    /**
     * Scroll down on the screen
     */
    public static void scrollDown() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endX = size.width / 2;
        int endY = (int) (size.height * 0.2);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startX, startY))
                   .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                   .moveTo(PointOption.point(endX, endY))
                   .release()
                   .perform();
    }

    /**
     * Scroll up on the screen
     */
    public static void scrollUp() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.2);
        int endX = size.width / 2;
        int endY = (int) (size.height * 0.8);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startX, startY))
                   .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                   .moveTo(PointOption.point(endX, endY))
                   .release()
                   .perform();
    }

    /**
     * Wait for element to be visible with custom timeout
     */
    public static MobileElement waitForElementToBeVisible(MobileElement element, int timeoutSeconds) {
        WebDriverWait customWait = new WebDriverWait(driver, timeoutSeconds);
        return (MobileElement) customWait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Wait for element to be clickable with custom timeout
     */
    public static MobileElement waitForElementToBeClickable(MobileElement element, int timeoutSeconds) {
        WebDriverWait customWait = new WebDriverWait(driver, timeoutSeconds);
        return (MobileElement) customWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Take screenshot for test reporting
     */
    public static String takeScreenshot(String testName) {
        try {
            // Implementation would depend on your reporting framework
            // This is a placeholder for screenshot functionality
            String screenshotPath = "target/screenshots/" + testName + "_" + System.currentTimeMillis() + ".png";
            // Add actual screenshot taking logic here
            return screenshotPath;
        } catch (Exception e) {
            System.err.println("Failed to take screenshot: " + e.getMessage());
            return null;
        }
    }

    /**
     * Hide keyboard if present
     */
    public static void hideKeyboard() {
        try {
            driver.hideKeyboard();
        } catch (Exception e) {
            // Keyboard might not be present or already hidden
            System.out.println("Keyboard not present or already hidden: " + e.getMessage());
        }
    }

    /**
     * Wait for app to load completely
     */
    public static void waitForAppToLoad() {
        try {
            Thread.sleep(3000); // Simple wait for app initialization
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Tap at specific coordinates
     */
    public static void tapAtCoordinates(int x, int y) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(x, y)).perform();
    }

    /**
     * Swipe from one point to another
     */
    public static void swipe(int startX, int startY, int endX, int endY) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startX, startY))
                   .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                   .moveTo(PointOption.point(endX, endY))
                   .release()
                   .perform();
    }
}
