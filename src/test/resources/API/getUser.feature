@RetrieveUser
Feature: Retrieve User
  @GetSingleUser
  Scenario: Successfully retrieve user details by user ID
    Given I have a user with ID "2"
    When I request the details for the user with ID "2"
    Then the response code should be 200
    And the response should contain the user ID "2" details
    Then validation response get user
    Then validation response json with JSONSchema "list_user.json"

  @SingleUserNotFound
  Scenario: Unsuccesfully retrieve non-existent user details by user ID
    Given I have a user with ID "23"
    When I request the details for the user with ID "23"
    Then the response code should be 404
    And the response should be null
    Then validation response  of non-existent user
    Then validation response json with JSONSchema "list_user.json"