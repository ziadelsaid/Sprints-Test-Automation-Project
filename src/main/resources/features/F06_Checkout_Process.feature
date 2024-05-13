@regression
Feature: F06 | User can complete checkout process
  Background: user login and add item to cart
    Given User is registered and logged in
    And user add any featured product to cart

  Scenario: user could checkout after filling all required data
    Given user clicks on cart
    Then user should be directed to cart page
    When user agree on terms and conditions
    And user clicks on checkout button
    And user chooses country: "Egypt"
    And user enters city: "Cairo"
    And user enters address: "New cairo, teseen street"
    And user enters postal code: "11835"
    And user enters phone number: "01017949179"
    And user presses continue to save address
    And user chooses "Ground" shipping method
    And user presses continue after choosing shipping method
    And user chooses "Check / Money Order" payment method
    And user presses continue after choosing payment method
    Then user should see overview information of order
    When user presses confirm
    Then user is redirected to checkout completed page