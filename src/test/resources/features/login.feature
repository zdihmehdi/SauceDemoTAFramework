Feature: Login functionality

  Background:
    Given User is on login page

  Scenario Outline: Successful login with valid credentials
    When User enters username <username> and password secret_sauce
    And User clicks on login button
    Then User is logged

    Examples:
      | username                |
      | standard_user           |
      | problem_user            |
      | performance_glitch_user |
      | error_user              |
      | visual_user             |

  Scenario: Locked user try to login
    When User enters locked username locked_out_user and password secret_sauce
    And User clicks on login button
    Then User is not logged

  Scenario Outline: Login with none existing accounts
    When User enters non existing accounts credentials: username <username> and password <password>
    And User clicks on login button
    Then User is not existing in the database

    Examples:
      | username       | password     |
      | standard_user  | 123456       |
      | problem_user_1 | secret_sauce |
      | mehdi          | secret_sauce |
      | error_user     | 123456       |
      | visual_user_1  | secret_sauce |

