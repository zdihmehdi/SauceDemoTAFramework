Feature: Logout functionality

  Background:
    Given the user is on the login page
    When the user enters username standard_user and password secret_sauce
    And the user clicks on login button
    Then the user is logged in successfully

  Scenario: Successful logout with valid credentials from product page
    When the user clicks on the burger menu button
    Then the burger menu is visible
    When the user clicks on the logout button
    Then the user is successfully logged out

  Scenario: Successful logout with valid credentials from checkout page
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
    When the user clicks on the burger menu button
    Then the burger menu is visible
    When the user clicks on the logout button
    Then the user is successfully logged out


  Scenario: Successful logout with valid credentials from checkout first step page
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
    When the user clicks on checkout button
    Then the checkout information form is visible
    When the user clicks on the burger menu button
    Then the burger menu is visible
    When the user clicks on the logout button
    Then the user is successfully logged out

  Scenario Outline: Successful logout with valid credentials from checkout second step page
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
    When the user clicks on checkout button
    And the user enters his firstname <firstname>, lastname <lastname>, and zip code <zipcode>
    And the user clicks on continue button
    Then the checkout second step page is visible
    When the user clicks on the burger menu button
    Then the burger menu is visible
    When the user clicks on the logout button
    Then the user is successfully logged out

    Examples:
      | firstname | lastname | zipcode |
      | mehdi     | test     | 1234    |