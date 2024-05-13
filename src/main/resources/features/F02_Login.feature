@regression
Feature: F02 | User login
  Scenario: User could register with registered e-mail and password successfully
    Given user clicks on Login tab
    Then user should be directed to login page
    When user enter existing email:
    And user enter right password:
    #And user select Remember me option
    And user clicks on Login Button
    Then user should be directed to homepage
    And user can see logout button