Feature: US-119_PostNewProductRequest

  @DB @apiRegression
  Scenario: TC_001 As a user, I should be able to request a new product.
    Given user logs in api as SELLEROMER
    When user requests a new product
    Then user verifies success true
    When User approve last added request product from database

  #@UI @DB @SellerLogin
   # Scenario:TC_002 approve the last your product
   # And user goes to Your requested products-services
   # When user click on random Hubs
    #And user scrolls down to the footer
    #When User approve last added request product from database

 # Scenario: TC_003 As a user, I should be able delete to request a new product.
  #  Given user logs in api as SELLEROMER
   # When user delete the approved a new product
   # Then user verifies success true

