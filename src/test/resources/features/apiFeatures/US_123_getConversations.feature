#Notifications
#User should be able to get all conversations.
#https://test.urbanicfarm.com/api/chat/getConversations
#Details on the swagger document.
@apiRegression
Feature: US_123 As a user, I should be able to get all conversations.
  Scenario: US_123 As a user, I should be able to get all conversations.
    Given user logs in api as BUYEROMER
    When User get all conversations
    Then User verify response is expected