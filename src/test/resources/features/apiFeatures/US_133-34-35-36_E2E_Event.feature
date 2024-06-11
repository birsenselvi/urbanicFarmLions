@apiRegression
Feature: E2E Test
  Scenario: E2E Test - Create,update,cancel and delete an event
    Given user logs in api as SELLEROMER
    When user creates a new event for api
    Then user verifies that the new event has been created
    When user updates event for api
    Then user verifies that the event has been updated
    When user cancels event for api
    Then user verifies that the event has been canceled
    When user deletes event for api
    Then user verifies that the event has been deleted