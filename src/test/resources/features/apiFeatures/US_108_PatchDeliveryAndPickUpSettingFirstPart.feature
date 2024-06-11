Feature: Delivery and PickUp Setting FirstPart
@apiRegretion
  Scenario: As a user, changes availability for buyer picks up from branch
    Given user logs in api as SELLEROMER
    When user sends a post request to change the availability for buyer picks up from branch
    Then the user verifies that the status code is 200
    And user verifies that response has success "true"