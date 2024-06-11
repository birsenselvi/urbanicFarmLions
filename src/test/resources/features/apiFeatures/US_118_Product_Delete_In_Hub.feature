@API @US_118 @apiRegression
Feature: Product/Services Delete

  Scenario: US_118 As a user, I should be able to delete a product
    Given user logs in api as SELLEROMER
    When User deletes an existing product.
    Then user verifies success true