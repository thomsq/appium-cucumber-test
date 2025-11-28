package com.saucelabs.mydemoapp.android.stepdefs;

import com.saucelabs.mydemoapp.android.base.BaseDriver;
import com.saucelabs.mydemoapp.android.pages.ProductDetailsPage;
import com.saucelabs.mydemoapp.android.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.junit.Assert;

public class ProductDetailsStep {

    private ProductsPage productsPage;
    private ProductDetailsPage productDetailsPage;
    private String selectedProductTitle;
    private String selectedProductPrice;

    @Before
    public void setup() throws Exception {
        BaseDriver.initializeDriver();
        productsPage = new ProductsPage();
        productDetailsPage = new ProductDetailsPage();
    }

    @After
    public void tearDown() {
        BaseDriver.quitDriver();
    }

    @Given("the user is on the products page")
    public void the_user_is_on_the_products_page() {
        Assert.assertTrue("Products page should be displayed",
                         productsPage.isProductsPageDisplayed());
        System.out.println("User is on the products page.");
    }

    @When("the user selects the first product")
    public void the_user_selects_the_first_product() {
        productsPage.selectProduct(1);
        System.out.println("Selected the first product.");
    }

    @When("the user selects a product by name {string}")
    public void the_user_selects_a_product_by_name(String productName) {
        productsPage.selectProductByName(productName);
        selectedProductTitle = productName;
        System.out.println("Selected product: " + productName);
    }

    @When("the user selects product at position {int}")
    public void the_user_selects_product_at_position(int position) {
        // Store product details before selecting
        selectedProductTitle = productsPage.getProductTitle(position);
        selectedProductPrice = productsPage.getProductPrice(position);

        productsPage.selectProduct(position);
        System.out.println("Selected product at position: " + position);
    }

    @Then("the product details page should be displayed")
    public void the_product_details_page_should_be_displayed() {
        Assert.assertTrue("Product details page should be displayed",
                         productDetailsPage.isProductDetailsPageDisplayed());
        System.out.println("Product details page is displayed.");
    }

    @Then("the product title should be displayed")
    public void the_product_title_should_be_displayed() {
        String actualTitle = productDetailsPage.getProductTitle();
        Assert.assertFalse("Product title should not be empty", actualTitle.isEmpty());
        System.out.println("Product title is displayed: " + actualTitle);
    }

    @Then("the product description should be displayed")
    public void the_product_description_should_be_displayed() {
        String description = productDetailsPage.getProductDescription();
        Assert.assertFalse("Product description should not be empty", description.isEmpty());
        System.out.println("Product description is displayed: " + description);
    }

    @Then("the product price should be displayed")
    public void the_product_price_should_be_displayed() {
        String price = productDetailsPage.getProductPrice();
        Assert.assertFalse("Product price should not be empty", price.isEmpty());
        Assert.assertTrue("Price should contain currency symbol", price.contains("$"));
        System.out.println("Product price is displayed: " + price);
    }

    @Then("the product image should be displayed")
    public void the_product_image_should_be_displayed() {
        Assert.assertTrue("Product image should be displayed",
                         productDetailsPage.isProductImageDisplayed());
        System.out.println("Product image is displayed.");
    }

    @Then("the add to cart button should be visible")
    public void the_add_to_cart_button_should_be_visible() {
        Assert.assertTrue("Add to cart button should be enabled",
                         productDetailsPage.isAddToCartButtonEnabled());
        System.out.println("Add to cart button is visible and enabled.");
    }

    @When("the user increases the quantity to {int}")
    public void the_user_increases_the_quantity_to(int targetQuantity) {
        int currentQuantity = productDetailsPage.getQuantity();
        while (currentQuantity < targetQuantity) {
            productDetailsPage.increaseQuantity();
            currentQuantity = productDetailsPage.getQuantity();
        }
        System.out.println("Increased quantity to: " + targetQuantity);
    }

    @When("the user selects {string} color")
    public void the_user_selects_color(String color) {
        productDetailsPage.selectColor(color);
        System.out.println("Selected color: " + color);
    }

    @When("the user adds the product to cart")
    public void the_user_adds_the_product_to_cart() {
        productDetailsPage.addToCart();
        System.out.println("Added product to cart.");
    }

    @Then("the quantity should be {int}")
    public void the_quantity_should_be(int expectedQuantity) {
        int actualQuantity = productDetailsPage.getQuantity();
        Assert.assertEquals("Quantity should match expected value", expectedQuantity, actualQuantity);
        System.out.println("Verified quantity: " + actualQuantity);
    }

    @When("the user goes back to products page")
    public void the_user_goes_back_to_products_page() {
        productDetailsPage.goBackToProducts();
        System.out.println("Navigated back to products page.");
    }

    @Then("the user should be back on the products page")
    public void the_user_should_be_back_on_the_products_page() {
        Assert.assertTrue("Should be back on products page",
                         productsPage.isProductsPageDisplayed());
        System.out.println("Successfully returned to products page.");
    }

    @Then("the product details should match the selected product")
    public void the_product_details_should_match_the_selected_product() {
        if (selectedProductTitle != null) {
            String actualTitle = productDetailsPage.getProductTitle();
            Assert.assertTrue("Product title should match selected product",
                            actualTitle.contains(selectedProductTitle) ||
                            selectedProductTitle.contains(actualTitle));
        }

        if (selectedProductPrice != null) {
            String actualPrice = productDetailsPage.getProductPrice();
            Assert.assertEquals("Product price should match selected product",
                              selectedProductPrice, actualPrice);
        }

        System.out.println("Product details match the selected product.");
    }
}
