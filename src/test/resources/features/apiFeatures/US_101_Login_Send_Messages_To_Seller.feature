@API @US_101 @apiRegression
Feature: As a user, I should be able to contact to Urbanic Farm.

  Scenario: US_101 - TC_001 User should be able to contact to Urbanic Farm.
    Given user logs in api as SELLEROMER
    When  user sends a message to Contact Us
    Then user verifies success true
