Feature: User can Login
  @tc1002 @login
  Scenario: User can Login into account
    When user enters valid email address and password
    And user click on Login button
    Then user navigate to My account page