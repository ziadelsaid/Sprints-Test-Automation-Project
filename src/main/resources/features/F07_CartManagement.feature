@regression
Feature: F07 | Cart Management
  Background:
    Given User is registered and logged in
    And user add any featured product to cart

  Scenario: User can Manage the cart by removing and adding functionality and check the price update
    When  user click on cart icon in top of page
    And   click on increase button
    Then  the quantity and price will increase
    When  click on decrease button
    Then  the quantity and price will decrease
    When  click on remove icon
    Then  the cart will Empty





