#NOTE BEFORE EXECUTING ---> JobTitle is unique field in NTK application, change the value before EACH Execution...
@SmokeTest
Feature: Job Titles Page Functionality

  Background: 
    Given User is logged in to NTK application

  Scenario: Verify Job Titles Header
    When User navigates to Job Titles Page
    Then Application displays Page Header "Job Titles"

  Scenario Outline: Verify user able to add new Job Title
    When User navigates to Job Titles Page
    And User clicks Add Icon
    And User enters "<JobTitle>", "<JobDescription>"
    And User clicks Save Button
    Then Application displays success message "Successfully Saved"

 
    Examples: 
      | JobTitle | JobDescription |
      | SCRUM1   | study more     |
      | Scrum2   | study more     |
      | scrum3   | study more     |




  Scenario: Verify user able to add new Job Title
    When User navigates to Job Titles Page
    And User clicks Add Icon
    And User enters job title data successfully
      | JobTitle           | JobDescription |
      | API Testinag233333 | more           |
      | Selenium           | webdriver      |
      | SQL                | study          |
    And User clicks Save Button
    Then Application displays success message "Successfully Saved"
