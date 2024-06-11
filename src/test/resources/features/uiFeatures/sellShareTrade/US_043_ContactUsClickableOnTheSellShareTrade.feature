
@UI @US_043
Feature: Sell Share Trade
  Scenario: Contact Us must be clickable on the Sell Share Trade page and relevant page must be visible
    Given The user goes to home page and logs in
#    When the user clicks on Sell Share Trade on the navbar
#    Then the user verifies that it is navigated to Sell Share Trade page
    And the user click on the ContactUs button
    Then the relevant page should be displayed