@apiRegression

  Feature: US129 As a user, I should be able to get all events details

    Scenario: User should be able to get all events details.

      Given user logs in api as SELLEROMER
      When User gets access to all events details
      Then user verifies success true

