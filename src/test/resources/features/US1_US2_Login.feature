Feature: As a user, I should be able to log in.

  Background:
    Given user on the login page

  Scenario Outline: Verify login with valid credentials
    When user use username "<username>" and passcode "<password>"
    And user click the login button
    Then verify the user should be at the dashboard page
    Examples:
      | username | password    |
      | user7    | Userpass123 |
      | user34   | Userpass123 |
      | user99   | Userpass123 |



  Scenario Outline: Verify user login fail with invalid credentials
    When user enter invalid "<username>" and "<password>"
    And user click the login button
    Then verify "<message>" message should be displayed

    Examples:
      | username | password    | message                     |
      | user9    | Wrong       | Wrong username or password. |
      | Wrong    | Userpass123 | Wrong username or password. |
      | Wrong    | Wrong       | Wrong username or password. |
