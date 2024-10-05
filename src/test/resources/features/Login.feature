Feature: Sauce Demo login Page

  user should be able to successfully login into the
  sauce demo page, provided with correct credentials

  Scenario: User logs into Sauce Demo successfully
    Given the user lands on Sauce Demo Landing page
    When the user enter valid credentials
    And the user clicks on the "Login" button
    Then the user is logged in and "Products" page is displayed