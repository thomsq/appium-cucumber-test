package com.saucelabs.mydemoapp.android.stepdefs;

import com.saucelabs.mydemoapp.android.base.BaseDriver;
import com.saucelabs.mydemoapp.android.pages.LoginPage;
import com.saucelabs.mydemoapp.android.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.Assert;

public class LoginStep {

    private LoginPage loginPage;
    private ProductsPage productsPage;

    @Before
    public void setup() throws Exception {
        BaseDriver.initializeDriver();
        loginPage = new LoginPage();
        productsPage = new ProductsPage();
    }

    @After
    public void tearDown() {
        BaseDriver.quitDriver();
    }

    @Given("the app is launched on the device")
    public void the_app_is_launched_on_the_device() {
        // App launch happens in the @Before method due to driver initialization.
        // Verify that we can see the products page (default landing page)
        Assert.assertTrue("Products page should be displayed after app launch",
                         productsPage.isProductsPageDisplayed());
        System.out.println("App launched successfully and products page is visible.");
    }

    @Given("the user navigates to the login page")
    public void the_user_navigates_to_the_login_page() {
        loginPage.navigateToLogin();
        System.out.println("Navigated to login page.");
    }

    @When("the user enters {string} into the username field")
    public void the_user_enters_username(String username) {
        loginPage.enterUsername(username);
        System.out.println("Entered username: " + username);
    }

    @When("the user enters {string} into the password field")
    public void the_user_enters_password(String password) {
        loginPage.enterPassword(password);
        System.out.println("Entered password: " + password);
    }

    @When("the user taps the Login button")
    public void the_user_taps_login_button() {
        loginPage.tapLoginButton();
        System.out.println("Tapped Login button.");
    }

    @Then("the user should see the Products page")
    public void the_user_should_see_the_products_page() {
        Assert.assertTrue("Products page should be displayed after successful login",
                         productsPage.isProductsPageDisplayed());
        System.out.println("Successfully validated presence of Products page.");
    }

    @Then("the user should see an error message")
    public void the_user_should_see_an_error_message() {
        Assert.assertTrue("Error message should be displayed for invalid credentials",
                         loginPage.isErrorMessageDisplayed());
        String errorMessage = loginPage.getErrorMessage();
        System.out.println("Successfully validated error message: " + errorMessage);
    }
}