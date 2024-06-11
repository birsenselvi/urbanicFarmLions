#US_082 As a user, I should be able to login    Login
#User should be able to log in.
#https://test.urbanicfarm.com/api/public/login
#Details on the swagger document.

#  Sevinc

Feature: US_082 As a user, I should be able to login

  Scenario: TC_001 user should be able to login
    Given user logs in api as BUYER
    Then the user verifies that the status code is 200
    Given user logs in api as SELLER
    Then the user verifies that the status code is 200
    Given user logs in api as BUYEROMER
    Then the user verifies that the status code is 200
    Given user logs in api as SELLEROMER
    Then the user verifies that the status code is 200
    Given user logs in api as SELLERGUL
    Then the user verifies that the status code is 200

