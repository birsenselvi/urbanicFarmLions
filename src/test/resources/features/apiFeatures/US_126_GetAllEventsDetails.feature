@apiRegression
@US_126
  @API

Feature: US_126_GetAllEventsDetails
  Scenario: TC_001 As a user, I should be able to get all events' details.
    Given user logs in api as BUYEROMER
    When user gets the all events details
    Then user verifies success true
    And the response body should contain details of all events




