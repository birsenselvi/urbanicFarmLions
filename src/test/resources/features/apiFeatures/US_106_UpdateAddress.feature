Feature: US_106
  @smoke
  Scenario: As a user, I should be able to update an existing address.

    Given user logs in api as SELLEROMER
    When the user add new address
    And user update address
    Then the user verifies that success is True





