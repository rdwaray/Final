@Cart
Feature: Manage items in the cart
  @Add-Cart
  Scenario: Adding items to cart
    Given User is on homepage
    When User clicks on product 1
    And User adds that item to the cart
    And User receives an alert
    And User goes back to the homepage
    When User clicks on product 2
    And User adds that item to the cart
    And User receives an alert
    Then User goes to the cart page
  @Delete-Cart
  Scenario: Delete item from cart
    Given User is on homepage
    When User clicks on product 3
    Then User adds that item to the cart
    And User goes to the cart page
    When User deletes 1 item from the cart
    And The item should be removed from the cart