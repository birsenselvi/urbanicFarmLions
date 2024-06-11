#Notifications
#User should be able to get unread message count.
#https://test.urbanicfarm.com/api/chat/getUnreadMessagesCount
#Details on the swagger document.
@apiRegression
Feature: US124 As a user, I should be able to get unread message count.
  Scenario: US124 As a user, I should be able to get unread message count.
    Given  user logs in api as SELLEROMER
    When User get unread message count
    Then User verify  message response is expected