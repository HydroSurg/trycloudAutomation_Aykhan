Feature: As a user, I should be able to access to Files module - Favorites button

  Story: As a user, I should be able to add file to favorites.

  Background:
    Given user on the login page
    When the users log in with valid credentials

@wip2
  Scenario: Verify users to add files to Favorites
    Given user on the dashboard page
    When the user clicks the "Files" module
    When the user clicks action-icon from any file on the page
    And user choose the "Add to favorites" option
    And user click the "Favorites" sub-module on the left side
    Then Verify the chosen file is listed on the table