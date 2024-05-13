@regression
Feature: F01 | Guest registration
  Scenario: guest user could register with valid data successfully
    When guest user clicks on Register Tab
    Then guest user should be directed to registering page
    When guest user chooses any Gender option
    And Fill First Name
    And Fill Last Name
    And Select Day
    And Select Month
    And Select Year
    And Enter any email
    And Enter any company name
    And Enter any password
    And Enter same password in Confirm Password field
    And Click on REGISTER button
    Then the user should be registered successfully
    And a success green message is displayed