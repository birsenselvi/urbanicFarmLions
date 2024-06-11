Feature: US_107
@smoke
  Scenario: As a user, I should be able to delete an existing address.

    Given user logs in api as SELLERGUL
    When user add new address
    When user get the adress
    And user delete address
    Then User verifies that success is true





