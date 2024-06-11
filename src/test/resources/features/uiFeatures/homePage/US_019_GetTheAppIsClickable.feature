Feature: US_019

  @UI
  Scenario: Get The App should be clickable and relevant page should be visible
    Given user goes to homepage
    When user scrolls down to the footer
    Then user click on the Get The App
    And user assert the page Social networking and marketplace - on iOS and Android



