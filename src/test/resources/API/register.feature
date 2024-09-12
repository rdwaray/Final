@UserRegistration
Feature: User Registration

  @Successfull-Registration
  Scenario: Successfully register a new user with valid details
    Given I provide a valid email "jeve.ss@holtreqres.in" and a valid password "pi23stol"
    When  I submit the registration request
    And the response register code should be 201
#    Then the response should contain the newly created user ID
    And the response should be validated
    And the response JSON should match the schema "register.json"

  @Unsuccessfull-Registration
  Scenario: Attempt to register with an invalid email format
    Given I provide an invalid email "invalidemail" and a valid password "pi23stol"
    When I submit the registration request
    And the response faliure register code should be 201
    Then the response should contain an error message about the invalid email
    And the faliure response JSON should match the schema "error_register.json"

  @MissingPassword-Registration
  Scenario: Attempt to register with a missing password
    Given I provide a valid email "jeve.holtreqres.in" and an empty password
    When I submit the registration request
    And the response faliure register code should be 201
    Then the response should contain an error message about the missing password
    And the faliure response JSON should match the schema "error_register.json"

  @MissingPasswordRegistration
  Scenario: Attempt to register with a missing email
    Given I provide an  empty email and a valid password "pi23stol"
    When I submit the registration request
    And the response faliure register code should be 201
    Then the response should contain an error message about the missing email
    And the faliure response JSON should match the schema "error_register.json"
