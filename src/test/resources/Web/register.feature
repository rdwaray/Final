@Register
Feature: Register
  @valid-Register
  Scenario: Successful register
    Given User is on the register page
    And  Register username with "Registarids"
    And Register password with "secretasauce"
    When User click  register button
    Then User receives alert register successfull
    And User is on homepage
  @invalid-Register
  Scenario: Unsuccessful register
    Given User is on the register page
    And Register username with "invalid_aser"
    Then User click  register button
    And User see error register message