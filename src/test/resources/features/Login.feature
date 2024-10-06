Feature: Sauce Demo login Page

  user should be able to successfully login into the
  sauce demo page, provided with correct credentials

  Scenario: User logs into Sauce Demo successfully
    Given the user lands on Sauce Demo Landing page
    When the user enter valid credentials
    And the user clicks on the "Login" button
    Then the user is logged in and "Products" page is displayed

  Scenario Outline: User logs in with invalid credentials
    Given the user lands on Sauce Demo Landing page
    When the user enter invalid credentials "<username>" and "<password>"
    And the user clicks on the "Login" button
    Then the error message "<error_message>" is displayed

    Examples:
      | username      | password     | error_message                                                             |
      | standard_user | secret_sauce | Epic sadface: Username is required                                        |
      | standard_user |              | Epic sadface: Password is required                                        |
      |               |              | Epic sadface: Username is required                                        |
      |               | secret_sauce | Epic sadface: Username is required                                        |
      | fineigei      | iwqfiwviisvw | Epic sadface: Username and password do not match any user in this service |