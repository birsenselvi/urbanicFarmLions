# new feature
# Tags: optional
@apiRegression
Feature: US_140_getWeeklyOrderbyId


    Scenario: TC_001 As a user, I should be able to get weekly order list
    Given user logs in api as BUYEROMER
        When user gets the WeeklyOrderbyId
        Then user verifies order id