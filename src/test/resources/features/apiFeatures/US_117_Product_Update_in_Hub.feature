@API @US_117 @DB @UI @apiRegression
Feature: Product/Services Update

  Scenario: US_117 As a user, I should be able to update an existing product.
    Given user logs in api as SELLEROMER
    When User updates an existing product.
    Then user verifies success true.