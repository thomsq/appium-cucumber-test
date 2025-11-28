package com.saucelabs.mydemoapp.android.data;

public class TestData {

    // Valid login credentials for SauceLabs Demo App
    public static class ValidCredentials {
        public static final String USERNAME = "bod@example.com";
        public static final String PASSWORD = "10203040";
    }

    // Invalid credentials for negative testing
    public static class InvalidCredentials {
        public static final String INVALID_USERNAME = "alice@example.com";
        public static final String INVALID_PASSWORD = "1234567";
        public static final String EMPTY_USERNAME = "";
        public static final String EMPTY_PASSWORD = "";
    }

    // Product related test data
    public static class ProductData {
        public static final String[] AVAILABLE_COLORS = {"red", "blue", "black", "gray"};
        public static final int DEFAULT_QUANTITY = 1;
        public static final int MAX_QUANTITY = 10;
    }

    // App configuration
    public static class AppConfig {
        public static final String APP_PACKAGE = "com.saucelabs.mydemoapp.android";
        public static final String SPLASH_ACTIVITY = "com.saucelabs.mydemoapp.android.view.activities.SplashActivity";
        public static final String APK_PATH = "/src/test/resources/builds/mda-1.0.13-15.apk";
        public static final String APPIUM_SERVER_URL = "http://127.0.0.1:4723/wd/hub";
    }

    // Device configuration
    public static class DeviceConfig {
        public static final String DEVICE_NAME = "Pixel_3a_API_34_x86_64";
        public static final String PLATFORM_NAME = "Android";
        public static final String AUTOMATION_NAME = "UiAutomator2";
    }

    // Timeouts and waits
    public static class Timeouts {
        public static final int DEFAULT_WAIT = 15;
        public static final int SHORT_WAIT = 5;
        public static final int LONG_WAIT = 30;
        public static final int IMPLICIT_WAIT = 10;
    }

    // Expected text messages
    public static class ExpectedMessages {
        public static final String PRODUCTS_TITLE = "Products";
        public static final String LOGIN_ERROR_MESSAGE_PATTERN = ".*[Ee]rror.*|.*[Ii]nvalid.*|.*[Ff]ail.*";
    }

    // Test user profiles for different scenarios
    public static class UserProfiles {

        public static class StandardUser {
            public static final String USERNAME = "standard_user";
            public static final String PASSWORD = "secret_sauce";
        }

        public static class ProblemUser {
            public static final String USERNAME = "problem_user";
            public static final String PASSWORD = "secret_sauce";
        }

        public static class PerformanceGlitchUser {
            public static final String USERNAME = "performance_glitch_user";
            public static final String PASSWORD = "secret_sauce";
        }
    }
}
