Feature: Register Event

  Scenario: User must be able to register an existing event
    Given user logs in api as BUYEROMER
    When user get all existing events thorough api
    And user sends a post request to register an existing event
    And user verifies success true
    And user verifies descr is "You have now registered to this event"
