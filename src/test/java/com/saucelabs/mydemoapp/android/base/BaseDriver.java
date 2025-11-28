package com.saucelabs.mydemoapp.android.base;

import com.saucelabs.mydemoapp.android.data.TestData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class BaseDriver {

    protected static AppiumDriver<MobileElement> driver;
    protected static WebDriverWait wait;

    public static void initializeDriver() throws Exception {
        if (driver == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", TestData.DeviceConfig.DEVICE_NAME);
            capabilities.setCapability("platformName", TestData.DeviceConfig.PLATFORM_NAME);
            capabilities.setCapability("automationName", TestData.DeviceConfig.AUTOMATION_NAME);
            capabilities.setCapability("appPackage", TestData.AppConfig.APP_PACKAGE);
            capabilities.setCapability("appActivity", TestData.AppConfig.SPLASH_ACTIVITY);
            capabilities.setCapability("app", System.getProperty("user.dir") + TestData.AppConfig.APK_PATH);
            capabilities.setCapability("noReset", false);
            capabilities.setCapability("fullReset", false);

            URL appiumServerUrl = new URL(TestData.AppConfig.APPIUM_SERVER_URL);
            driver = new AndroidDriver<MobileElement>(appiumServerUrl, capabilities);
            wait = new WebDriverWait(driver, TestData.Timeouts.DEFAULT_WAIT);
        }
    }

    public static AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            wait = null;
        }
    }
}