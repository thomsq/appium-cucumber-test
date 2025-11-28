package com.saucelabs.mydemoapp.android.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/product_details.feature",
        glue = {"com.saucelabs.mydemoapp.android.stepdefs"},
        plugin = {"pretty", "html:target/cucumber-reports/product-details-report.html"},
        dryRun = false,
        tags = ""
)
public class ProductDetailsTestRunner {
    // Test runner for product details functionality only
}
