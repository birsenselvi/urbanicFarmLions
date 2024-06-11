@apiRegression
@API @US_125

  Feature: US_125-As a user, I should be able to recieve all notifications.

    Scenario: User should be able to recieve and access all notification details
      Given user logs in api as SELLEROMER
      When user gets access to all notificatins
      Then user verifies success true
      And user verifies Notification details