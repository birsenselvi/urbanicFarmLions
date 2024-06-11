@apiRegression
Feature: As a user, I should be able to create an event
  Scenario: User should be able to create an event
    Given user logs in api as SELLEROMER
    When user creates a new event for api
    Then user verifies that the new event has been created

