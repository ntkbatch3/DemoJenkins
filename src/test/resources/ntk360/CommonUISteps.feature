# This steps are common which you can use among different automation scenarios, DONT RUN this File, Copy the steps and put in your scenario
Feature: Common UI actions across project

  Scenario: Use below common steps for different automation test cases
    Given User is logged in to NTK application
    When User clicks Add Icon
    And User clicks Edit Icon
    And User clicks Cancel Button
    And User clicks Save Button
    And Application displays success message "Successfully Saved"
    And Application displays Page Header "Job Titles"
    
 
