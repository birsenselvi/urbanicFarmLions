@apiRegression
Feature: US_138 getting weekly order list

  Scenario: US_138 getting weekly order list
      Given user logs in api as BUYEROMER
      When user gets WeeklyOrderList
      And the response body should contain details of all weekly orderlists

