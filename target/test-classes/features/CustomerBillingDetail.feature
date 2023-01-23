Feature: Customer should add billing information  and see  correct information about product in cart
  Background:
    When user enters valid email address and password
    And user click on Login button
    Then user navigate to My account page
    When User clicks on Shop by Category option
    And User select category for selecting product to purchase
    And User from Product Page select any item
    And User clicks on Add to Cart button from Category Page
    Then User should see success message that item was added

  Scenario: Customer provides billing detail in checkout page and after lands on OrderConfirmation Page
    where address, product name and price should match and order has been confirmed
    When Customer go to Checkout page
    And Customer provides billing information
    And Customer should see product name and its respective price
    