@UI @US_007
Feature: Verify Contact Us functionality on HomePage
  Scenario: Contact Us should be clickable on the Header and relevant page should be visible
   Given user goes to the home page
    When User click on the ContactUs button
   Then The relevant Contact Us page should be visible