@Login
@Valid-login
Feature: Login
  Scenario: Successful login
    Given User in on login form
    And User input correct username with "standard_user"
    And User input correct password with "secret_sauce"
    When User click on login button
    Then User is on homepage

  @Invalid-login
  Scenario: Unsuccessful login
    Given User in on login form
    And  User input incorrect username with "invalid_user"
    And  User input incorrect password with "wrong_password"
    When User click on login button
    And User see error message
    Then User back to login form
