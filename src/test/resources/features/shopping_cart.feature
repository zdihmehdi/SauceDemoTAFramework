Feature: Shopping cart functionality

  Background:
    Given User is on login page
    When User enters username standard_user and password secret_sauce
    And User clicks on login button
    Then User is logged

  Scenario: Checkout with an empty cart
    Given the list of products is visible
    And products are available
    When the user removes all products from the shopping cart in product page
    Then the cart badge should not be visible
    When the user clicks on the cart icon
    Then the checkout page should be visible
    And shopping cart is empty
    And the checkout button should be disabled

  Scenario: Checkout with non-empty cart
    Given the list of products is visible
    And products are available
    When the user removes all products from the shopping cart in product page
    Then the cart badge should not be visible
    When the user adds some products to the shopping cart
    Then the cart badge should be visible
    And the cart badge should show the number of chose products
    When the user clicks on the cart icon
    Then the checkout page should be visible
    And the checkout button should be enabled

  Scenario Outline: Checkout with non-empty cart and successfully buy the product
    Given the list of products is visible
    And products are available
    When the user removes all products from the shopping cart in product page
    Then the cart badge should not be visible
    When the user adds some products to the shopping cart
    Then the cart badge should be visible
    And the cart badge should show the number of chose products
    When the user clicks on the cart icon
    Then the checkout page should be visible
    And the checkout button should be enabled
    When the user click continue button
    And the user enters his firstname <firstname>, lastname <lastname>, and zip code <zipcode>
    And the user clicks on continue button
    And the user clicks on finish button
    Then the order should be successfully placed

    Examples:
      | firstname | lastname | zipcode |
      | mehdi     | test     | 1234    |