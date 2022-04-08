
Feature: As a user, I should be able to update settings

  Background:
    Given user on the login page
    When the users log in with valid credentials



  @wip
  Scenario: Verify users to see the app storage usage
    Given user on the dashboard page
    When the user clicks the "Files" module
    And user checks the current storage usage
    And users uploads file with the "Upload file" option
    And user refresh the page
    Then the user should be able to see storage usage is increased