@regression
Feature: F08 | User can manage his information

  Background:
    Given User is registered and logged in

  Scenario: change information of account
    When click on my account  icon
    And  change first name with "Mahmoud"
    And  change last name"Sami"
    And  change email
    And  change company name with "sprints"
    And  choose newsletter
    And  do Save
    Then the info has been updated
    When view order history

