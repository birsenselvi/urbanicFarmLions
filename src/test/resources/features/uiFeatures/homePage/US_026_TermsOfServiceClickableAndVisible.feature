Feature: US026

#Terms Of Service should be clickable and relevant page should be visible
  @UI
  Scenario: User checks Terms Of Service
    Given user goes to homepage
    And User goes the end of page
    And User clicks Terms Of Service button
    Then User verifies the relevant page changed