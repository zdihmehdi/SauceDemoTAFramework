Feature: Filter functionality

  Background:
    Given the user is on the login page
    When the user enters username standard_user and password secret_sauce
    And the user clicks on login button
    Then the user is logged in successfully

  Scenario Outline: Filter the products in ascending and descending order based on the name
    Given the list of products is visible
    When the user chooses the <meaning> name filter <value>
    Then the names of the products are ordered in <meaning> order

    Examples:
      | value      | meaning    |
      | az         | ascending  |
      | za         | descending |

  Scenario Outline: Filter the products in ascending and descending order based on the price
    Given the list of products is visible
    When the user chooses the <meaning> price filter <value>
    Then the prices of the products are ordered in <meaning> order

    Examples:
      | value      | meaning    |
      | lohi         | ascending  |
      | hilo         | descending |


