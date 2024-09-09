@CreatePatchUpdate
Feature: Create Patch and Update User
  @UpdateUser
  Scenario: Successfully update user details
    Given I have user 2 data with name "Ray" and job "QA"
    When I send a PUT request to update the user
    Then the response update code post should be 200
    And the response should contain the user updated data
    And the response should match the JSON schema "create_update_patch.json"
  @CreateUser
  Scenario: Successfully create a new user
    Given I have user 2 data with name "Dimas" and job "Tidur"
    When I send a POST request to create the user
    Then the response create code should be 201
    And the response should contain the created user data
    And the response should match the JSON schema "create_update_patch.json"
  @PatchUser
  Scenario: Successfully patch user details
    Given I have user 2 data with name "Ray" and job "QA"
    When I send a PATCH request to update the user
    Then the response patch code post should be 200
    And the response should contain the user patch data
    And the response should match the JSON schema "create_update_patch.json"

