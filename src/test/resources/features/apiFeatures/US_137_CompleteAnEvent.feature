@apiRegression
Feature: US_137_CompleteAnEvent

  Scenario: TC_001_CompleteAnEvent
      Given user logs in api as BUYEROMER
      When user completes an event
      Then user verifies success true