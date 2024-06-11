@UI
@US_075
@smoke
Feature: US_075 As a user, should not able to create Event(s) providing invalid data
  Scenario: Required fields on the create a new event page
    Given The user goes to home page and logs in as a seller
    When The user clicks on My Events subtab
    And the user clicks on Create New Event button.
    And the user must see the related warning message for the required fields.
    And user clicks on GO BACK button
    Then user verifies that it is navigated to event organize page.