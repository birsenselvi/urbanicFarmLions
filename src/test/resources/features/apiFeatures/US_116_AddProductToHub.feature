Feature: Products & Services

  Scenario: User must be able to add a product to the hub.
    Given user logs in api as SELLEROMER
    When user sends a post request to add a product to the hub
    Then the user verifies that the status code is 200
    And user verifies success true
    And user verifies descr is "Product added."
    And product details should be as expected.
    When user send a request to delete the product
    Then user verifies success true
