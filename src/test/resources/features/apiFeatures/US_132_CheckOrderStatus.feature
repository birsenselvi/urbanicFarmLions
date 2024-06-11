@apiRegression
Feature: US_132_CheckOrder
  Scenario: TC_001 As a user, I should be able to check order status
    Given user logs in api as SELLEROMER
    When user gets the order status
    Then user verifies order status id