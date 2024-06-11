Feature: Sell Share Trade
  Background:
    Given user goes to home page and logs in
    @UI @EventsOnSellShareTrade
  Scenario: Events must be clickable on the Sell Share Trade page and relevant page must be visible
      When user clicks on Sell Share Trade on the navbar
      Then user verifies that it is navigated to Sell Share Trade page
      And Events module should be clickable on this page
      When user clicks on Events on the left hand side menu
      Then relevant page should be displayed