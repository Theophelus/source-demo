Feature: End to end checkout

  As a user, I want to be able to log in to Sauce Demo, add items to my cart, and successfully complete the checkout process.

  Background:
    Given the user lands on Sauce Demo Landing page
    When the user enter valid credentials
    And the user clicks on the "Login" button

  @e2e
  Scenario: User adds items in the cart and complete checkout
    When the user adds these two items to the cart:
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |
    And the the cart icon should have two items
    And the user clicks on the cart icon
    Then "Your Cart" text is displayed
    And the user click on the checkout button
    And the user fills in the Checkout information form
    And the user clicks on the Continue button from checkout page
    Then "Checkout: Overview" text is displayed
    And the user clicks on the Finish button
    Then "Thank you for your order!" message is displayed