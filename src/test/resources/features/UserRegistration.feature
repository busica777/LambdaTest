Feature: User can create new account
@tc1001 @registration
  Scenario: user registration
    When user click on My account button
    And user click on Continue button under New Customer option
    And user enters personal information
    And user clicks on Continue button
    Then user see registration success message
