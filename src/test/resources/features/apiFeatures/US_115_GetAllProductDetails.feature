@US_115 @apiRegression
Feature: As a user, I should be able to receive all products' details

  Scenario: User gets all product details
    Given user logs in api as BUYEROMER
    When user gets all product details
    Then the user verifies that the status code is 200
    And the response body should contain details of all products