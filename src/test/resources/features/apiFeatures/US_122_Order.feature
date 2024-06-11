#As a user, I should be able to get all orders.
# Orders
# User should be able to get all orders.
# https://test.urbanicfarm.com/api/account/order/get/myBuys
# Details on the swagger document.
@apiRegression
Feature: US_122, As a user, I should be able to get all orders.
  Scenario: TC_001 I should be able to get all orders.
    Given user logs in api as SELLEROMER
    And the user connects to the getmyBuys api
    Then the user verifies buyer ids numbers more than one
