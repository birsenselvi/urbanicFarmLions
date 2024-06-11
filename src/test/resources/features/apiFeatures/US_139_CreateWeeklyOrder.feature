@apiRegression
Feature: US139 As a user, I should be able to create, get scheduled order
  Scenario: create new weekly order

   Given user logs in api as SELLEROMER
    When  User create a new scheduled order
    Then  User verifies that response is as expected
