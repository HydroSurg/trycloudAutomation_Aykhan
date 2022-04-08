@US8
Feature: As a user, I should be able to delete a file/folder.
  Story: As a user, I should be able to delete a file/folder.

  Background:
    Given user on the login page
    When the users log in with valid credentials


  Scenario: Verify users delete a file/folder
    Given user on the dashboard page
    When the user clicks the "Files" module
    And the user clicks action-icon from any file on the page
    And user choose the "Delete" option
    When user click the "Deleted files" sub-module on the left side
    Then Verify the deleted file is displayed on the page.