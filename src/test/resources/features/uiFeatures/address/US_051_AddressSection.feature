@UI @US051
Feature: Checking various actions on Address Page
  Background:
    Given user goes to homepage
    When the user clicks on the Login button
    Then completes the login form with valid "email" and "password"
    Then clicks on the Login button
    Then the user enters a valid zip code
    And clicks on the GO button
    Given user clicks on the address button
  Scenario:Address side bar must be clickable
    When User verifies that it is navigated to Address page.
    And the user clicks on Add New Address button and add a new city name.
    And The user clicks on cancel button.
    Then After the user clicks on the cancel button, user returns to address page.
