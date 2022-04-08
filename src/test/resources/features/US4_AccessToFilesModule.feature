
Feature: As a user, I should be able to access to Files module.
  Story: As a user, I should be able to access to Files module.

  Background:
    Given user on the login page
    When the users log in with valid credentials
    When the user clicks the "Files" module


  Scenario: verify users can access to Files module Given user on the dashboard page
    Then verify the page title is "Files - Trycloud"


  Scenario: verify users can select all the uploaded files from the page Given user on the dashboard page
    And user click the top-left checkbox of the table
    Then verify all the files are selected