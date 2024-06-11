@apiRegression
Feature:As a user, I should be able to cancel an event
  Scenario: User should be able to cancel an event
    Given user logs in api as SELLEROMER
    When user creates a new event for api
    And user cancels event for api
    Then user verifies that the event has been canceled