@regression
Feature: F09 | Add products to wishlist
  Scenario: success message is visible after adding product to wishlist
    When user add product to wishlist
    Then wishlist notification success is visible

  Scenario: number of wishlist items in home page increased
    When user add product to wishlist
    Then wishlist notification success is visible
    And user get the number of wishlist items after adding product
    Then number of wishlist items increased