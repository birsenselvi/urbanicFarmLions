Feature: US_111 As a user, I should be able to change delivery settings

  Scenario: TC_001 user should be able to login
    Given user logs in api as SELLER
    Then the response status code should be 200
    When user updates the seller flexible delivery option
#    Then the user verifies success is TRUE
#    Then User verifies that success is true