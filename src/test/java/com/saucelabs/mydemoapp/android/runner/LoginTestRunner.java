package com.saucelabs.mydemoapp.android.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/login.feature",
        glue = {"com.saucelabs.mydemoapp.android.stepdefs"},
        plugin = {"pretty", "html:target/cucumber-reports/login-report.html"},
        dryRun = false,
        tags = ""
)
public class LoginTestRunner {
    // Test runner for login functionality only
}
