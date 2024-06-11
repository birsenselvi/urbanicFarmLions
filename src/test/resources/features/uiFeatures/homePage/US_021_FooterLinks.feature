Feature: Footer Links Check on the HomePage
  @UI @US_021
  Scenario:Scheduled Delivery link on the footer under Features should be working as expected
    Given user goes to the home page
    When user scrolls down to the footer
    Then user should see Scheduled Delivery link under Features
    And link should be clickable
    And when it is clicked relevant page should be displayed.
