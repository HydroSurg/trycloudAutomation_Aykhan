@US7
Feature: As a user, I should be able to remove files from the favorites and upload a file directly
  Story: As a user, I should be able to manage folders.


  Background:
    Given user on the login page
    When the users log in with valid credentials


  Scenario: Verify users can add the folder
    Given user on the dashboard page
    When the user clicks the "Files" module
    And the user clicks the add icon on the top
    And user click "New folder"
    And user write a folder name
    When the user click submit icon
    Then Verify the folder is displayed on the page



  Scenario: Verify users can upload a file inside a folder
    Given user on the dashboard page
    When the user clicks the "Files" module
    And user choose a folder from the page
    And the user clicks the add icon on the top
    And users uploads file with the "Upload file" option
    Then verify the file is displayed on the page