@apiRegression
  @US_128
@API
Feature: US_128_UserAttendanceInformation
  Scenario: TC_001 As a user, I should be able to get user attendance information.
    Given user logs in api as BUYEROMER
    When user gets the attendance information
    Then user verifies success true
    And the response body should contain details of attendance information