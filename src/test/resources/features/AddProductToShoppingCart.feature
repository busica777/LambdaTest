@tc1003 @shoppingCart
Feature: Adding items to shopping cart

  Background:
    When user enters valid email address and password
    And user click on Login button
    Then user navigate to My account page

  Scenario: User should able to add wished items to shopping cart
    When User clicks on Shop by Category option
    And User select category for selecting product to purchase
    And User from Product Page select any item
    And User clicks on Add to Cart button from Category Page
    Then User should see success message that item was added