Feature: US_028_Phone Visible
  @UI @US_028
    Scenario: Phone should be visible in footer at HomePage
    Given user goes to homepage
    And user scrolls down to the footer
    And user checks "Phone:" text visible
    Then user checks "+1 (669) 696-5906" is visible