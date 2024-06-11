Feature: US_011

  @UI
  Scenario: Check Sell your produce title is visible
    Given user goes to homepage
    When user scrolls down to "Sell your produce" and Find the "Sell Your Products"
    And Assert title is "Sell your produce"
