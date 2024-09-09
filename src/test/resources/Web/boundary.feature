@Boundary
Feature: Boundary
  @Boundary-test
  Scenario: Boundary register test with registered user
    Given User is on register page
    And User input boundary username with "standard_user"
    And User input boundary password with "standard_password"
    When User click on register button
    Then User see error message
