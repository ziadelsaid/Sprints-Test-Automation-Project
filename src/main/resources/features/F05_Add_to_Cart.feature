@regression
Feature: F05 | User can add to cart

  Scenario: User can add featured product to cart from homepage
    When user add item: "HTC One M8 Android L 5.0 Lollipop" to cart
    Then item: "HTC One M8 Android L 5.0 Lollipop" is added to cart


  Scenario: User can add multiple items to cart from category and item pages
    Given user navigate camera category
    When user add item: "Leica T Mirrorless Digital Camera" to cart
    Then item: "Leica T Mirrorless Digital Camera" is added to cart
    When user add item: "Nikon D5500 DSLR" to cart
    Then user should be directed to item page
    When user add item variant: "Nikon D5500 DSLR - Red" to cart
    Then item: "Nikon D5500 DSLR - Red" is added to cart
