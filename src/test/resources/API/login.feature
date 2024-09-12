@UserLogin
Feature: User Login

  @Successfull-Login
  Scenario: Successfully login a new user with valid details
    Given I provide login data a valid email "jeve.holt@reqres.in" and a valid password "cityslicka"
    When  I submit the login request
    And the response login code should be 201
    And the response login should be validated
    And the response login JSON should match the schema "login.json"

  @MissingPassword-Login
  Scenario: Attempt to login with a missing password
    Given I provide login data a valid email "jeve.holt@reqres.in" and an empty password
    When I submit the login request
    And the response faliure login code should be 201
    Then the response login should contain an error message about the missing password
    And the faliure login response JSON should match the schema "login.json"

  @MissingPassword-Login
  Scenario: Attempt to login with a missing email
    Given I provide login data an  empty email and a valid password "cityslicka"
    When I submit the login request
    And the response faliure login code should be 201
    Then the response login should contain an error message about the missing email
    And the faliure login response JSON should match the schema "login.json"



