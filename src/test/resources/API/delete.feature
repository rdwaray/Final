@Delete
Feature: Delete User
  @DeleteUser
  Scenario: Successfully delete a user by ID
    Given I have a user with ID 2
    When I send a DELETE request to remove the user
    Then the response status code should be 204
    And the response body should be empty
    And the user with ID 2 should no longer exist
