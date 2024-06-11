@UI @US_030
Feature: Verify Facebook icon functionality on HomePage

  Scenario: Contact Us should be clickable on the Header and relevant page should be visible
    Given user goes to the home page
    When user scrolls down to the footer
    When User click on the Facebook icon
   Then The relevant Facebook page should be visible

