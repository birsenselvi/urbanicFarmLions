@UI
  @US_046

Feature: User Login and Sell-Share-Trade Page Operations
  Background:
    Given user goes to homepage


  Scenario: User logs in and performs operations on the Sell-Share-Trade page
    When the user clicks on the Login button
    Then completes the login form with valid "email" and "password"
    Then clicks on the Login button
    Then the user enters a valid zip code
    And clicks on the GO button
    And the user is on the Sell-Share-Trade page
    And the username on the page should be clickable
