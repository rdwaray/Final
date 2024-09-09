@RetrieveAllUserDetails
Feature: Retrieve All User Details
  @GetAllUser
  Scenario: Successfully retrieve all user detail
    Given I ask all user detail on page 2
    When I request the details for theall user detail on page 2
    Then the response code getAllUser should be 200
    And the response should contain of all user detail on page 2
    Then validation response get all user
    Then validation response getAllUser json with JSONSchema "list_all_user.json"