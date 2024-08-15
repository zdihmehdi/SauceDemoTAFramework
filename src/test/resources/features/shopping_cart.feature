Feature: Shopping cart functionality

  Background:
    Given the user is on the login page
    When the user enters username standard_user and password secret_sauce
    And the user clicks on login button
    Then the user is logged in successfully

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

  Scenario Outline: Successfully purchase the product and then go back home
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
    When the user clicks the back home button
    Then the cart badge should not be visible
    And all add/remove buttons should have the text Add to cart

    Examples:
      | firstname | lastname | zipcode |
      | mehdi     | test     | 1234    |

  Scenario Outline: Add and remove products from shopping cart
    Given the list of products is visible
    And products are available
    When the user removes all products from the shopping cart in product page
    Then the cart badge should not be visible
    When the products: <products> are available
    Then the user adds <products> items to the shopping cart
    And the cart badge should be visible
    And the cart badge shows <number>
    When the user clicks on the cart icon
    Then the checkout page should be visible
    And the checkout button should be enabled
    When the user delete <deleteProduct> product from checkout page
    Then <numberRemaining> remaining products are showed
    And the <deleteProduct> product disappear from cart page
    When the user clicks continue shopping
    Then the removed product/products <deleteProduct> add/remove button shows Add to cart text

    Examples: Products to add
      | products                                                      | number | deleteProduct      | numberRemaining |
      | Sauce Labs Backpack, Sauce Labs Bike Light, Sauce Labs Onesie | 3      | Sauce Labs Onesie  | 2               |