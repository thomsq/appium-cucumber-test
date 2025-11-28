@products
Feature: Product Details Viewing

  Background:
    Given the app is launched on the device
    And the user is on the products page

  @smoke @positive
  Scenario: View product details for the first product
    When the user selects the first product
    Then the product details page should be displayed
    And the product title should be displayed
    And the product description should be displayed
    And the product price should be displayed
    And the product image should be displayed
    And the add to cart button should be visible

  @positive @validation
  Scenario: View product details and verify information consistency
    When the user selects product at position 1
    Then the product details page should be displayed
    And the product details should match the selected product

  @cart @positive
  Scenario: Customize product options and add to cart
    When the user selects the first product
    Then the product details page should be displayed
    When the user increases the quantity to 3
    And the user selects "red" color
    Then the quantity should be 3
    When the user adds the product to cart
    Then the add to cart button should be visible

  @navigation @positive
  Scenario: Navigate back to products page from product details
    When the user selects the first product
    Then the product details page should be displayed
    When the user goes back to products page
    Then the user should be back on the products page

  @positive @multiple
  Scenario: View multiple product details
    When the user selects product at position 1
    Then the product details page should be displayed
    And the product title should be displayed
    When the user goes back to products page
    And the user selects product at position 3
    Then the product details page should be displayed
    And the product title should be displayed
