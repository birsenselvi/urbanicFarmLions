Feature: Delivery Pick Up Settings

  Scenario: As a user, I must be able to change availability for seller delivers the products.
    Given user logs in api as SELLER
    When user sends a post request to change the availability of delivering the products
    Then the user verifies that the status code is 200
    And user verifies that response has success "true"