@UI
@US_049

Feature: User verify that basket is clickable

  Scenario: US_049
    Given user goes to homepage
    And User logs in with Buyer credentials
    And the user close the  zipcode window
    And user clicks the basket on the navbar
   Then the relevant page associated with current Url