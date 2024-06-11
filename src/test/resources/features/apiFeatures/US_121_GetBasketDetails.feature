Feature: US_121_GetBasketDetails
  Scenario: TC_001 As a user, I should be able to get basket details.
    Given user logs in api as BUYEROMER
    When user gets the basket details
    Then user verifies basket details id