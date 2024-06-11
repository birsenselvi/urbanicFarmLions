@apiRegression
Feature: As a user, I should be able to delete an event
  Scenario: User should be able to delete an event
    Given user logs in api as SELLEROMER
    When user creates a new event for api
    And user deletes event for api
    Then user verifies that the event has been deleted