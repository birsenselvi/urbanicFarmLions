
@apiRegression
Feature: US_105

  Scenario: As a user, I should be able to add an existing address.

    Given user logs in api as SELLER
    When user add new Address
    Then User verifies that success is True

