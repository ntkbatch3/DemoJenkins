#NOTE BEFORE EXECUTING ---> JobTitle is unique field in NTK application, change the value before EACH Execution...
@SmokeTest
Feature: Job Titles Page Functionality

  Background: 
    Given User is logged in to NTK application

  Scenario Outline: Verify user able to add new Job Title
    When User navigates to Job Titles Page
    And User clicks Add Icon
    And User enters "<JobTitle>", "<JobDescription>"
    And User clicks Save Button
    Then Application displays success message "Successfully Saved"

    Examples: 
      | JobTitle | JobDescription |
      | SDET10111  | study more     |
