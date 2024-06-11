@smoke
Feature: US-120_GetProductRequest
@apiRegression
  Scenario: TC_001 As a user, I should be able to request a new product.
    Given user logs in api as SELLEROMER
    When user requests a new product
    Then user verifies success true

  @DB @apiRegression
  Scenario: TC_002 As a user, I should be able to get all requested products' information.
    Given user logs in api as SELLEROMER
    When user get all requested products' information
    Then user verifies product request title "RedRose"
    When User approve last added request product from database


  #Scenario: TC_003 As a user, I should be able delete to request a new product.
   # Given user logs in api as SELLEROMER
   # When user delete the approved a new product
   # Then user verifies success true
