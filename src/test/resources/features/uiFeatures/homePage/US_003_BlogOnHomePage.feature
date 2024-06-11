Feature: Homepage Blog
  @UI
  @US003
  @LU_59 @smoke
  Scenario: US_003
    Given user goes to homepage
    When the user clicks on the Blog button
    Then the relevant Blog page should be visible
