@apiRegression
  @US_127
@API

Feature: US_127_GetMyEventsInformation
  Scenario: TC_001 As a user, I should be able to get my events' information.
    Given user logs in api as BUYEROMER
    When user receives the all my events info
    Then user verifies success true
    And the response body should contain details of all my events
