Feature: Products Sauce Demo Page

  User should be able to filter, products and add them to the cart.

  Scenario: Add 2 items to the cart
    Given the user lands on Sauce Demo Landing page
    When the user enter valid credentials
    And the user clicks on the "Login" button
    And the user is logged in and "Products" page is displayed
    And the user adds these two items to the cart:
      | Sauce Labs Backpack   |
      | Sauce Labs Bike Light |

    Then the the cart icon should have two items