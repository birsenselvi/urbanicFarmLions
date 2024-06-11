@UI @US_024
Feature:User should be able to perform various operations on homepage
  Scenario:Contact Us should be clickable on the footer and relevant page should be visible
    Given user goes to the home page
    When user scrolls down to the footer
    When user clicks the Contact Us icon
    And  the Contact Us icon should be clickable
    Then When it is clicked and relevant page should be displayed for the Contact Us on the footer