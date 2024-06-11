 @LU-91  @UI
Feature: us 17

  @TEST_LU-83 @smoke
  Scenario: TC_001
    Given user goes to the home page
    When user scrolls down to the footer
    And user clicks on the farmers market
    And user clicks on the popup
    Then user should see relevant page and url "https://test.urbanicfarm.com/auth/login?route=/account/weekly-order"