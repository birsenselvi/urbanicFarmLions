Feature: Go To Payment After Registering an Event

  Scenario: User must be able to go to payment.
    Given user logs in api as BUYEROMER
    When user get all existing events thorough api
    And user sends a post request to register an existing event
    When user submits a post request to go to payment
    Then the user verifies that the status code is 200
    And user verifies success true
    And user verifies descr is "You have approved the attendace request"