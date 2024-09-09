@Order
Feature: Order placement

  @valid-order
  Scenario: Place a successful order
    Given User is on the order page
    Then User places an order with details:
      | Name      | Country | City  | CreditCardNumber  | ExpiryMonth | ExpiryYear |
      | Ray       | IDN     | Mana  | 25222             | 02          | 2077       |
    And User click on order button
    Then User receives message order succesfull
  @invalid-order
  Scenario: Unsuccessful order
    Given User is on the order page
    When User places an order with details:
      | Name      | Country | City  | CreditCardNumber  | ExpiryMonth | ExpiryYear |
      |           | IDN     | Mana  |                   | 02          | 2077       |
    And User click on order button
    Then User receives message order unsuccesfull
