@apiRegression
@API @US_104

  Feature:US_104-As a user, I should be able to get address information.

    Scenario: User should be able to access address details.
      Given user logs in api as SELLEROMER
      When User gets access to addrress information
      Then user verifies success true
      And user verifies address details