Feature: Retrieve User Details
  Scenario: Successfully retrieve user details by user ID
    Given I have a user with ID "2"
    When I request the details for the user with ID "2"
    Then the response code should be 200
    And the response should contain the user ID "2" details