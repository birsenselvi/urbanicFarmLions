@apiRegression
Feature: As a user, I should be able to update an event
  Scenario: User should be able to update an event
    Given user logs in api as SELLEROMER
    When user creates a new event for api
    And user updates event for api
    Then user verifies that the event has been updated

