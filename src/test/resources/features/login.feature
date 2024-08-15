Feature: Login functionality

  Background:
    Given the user is on the login page

  Scenario Outline: Successful login with valid credentials
    When the user enters username <username> and password secret_sauce
    And the user clicks on login button
    Then the user is logged in successfully

    Examples:
      | username                |
      | standard_user           |
      | problem_user            |
      | performance_glitch_user |
      | error_user              |
      | visual_user             |

  Scenario: Locked user try to login
    When the user enters locked username locked_out_user and password secret_sauce
    And the user clicks on login button
    Then the user is not logged in and sees an error message indicating the account is locked

  Scenario Outline: Login with none existing accounts
    When the user enters non existing accounts credentials: username <username> and password <password>
    And the user clicks on login button
    Then the user is not existing in the database

    Examples:
      | username       | password     |
      | standard_user  | 123456       |
      | problem_user_1 | secret_sauce |
      | mehdi          | secret_sauce |
      | error_user     | 123456       |
      | visual_user_1  | secret_sauce |

