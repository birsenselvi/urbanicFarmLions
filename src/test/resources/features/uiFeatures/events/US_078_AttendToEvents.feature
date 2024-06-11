@US_078

Feature: User attends the someone's event(s)

  @UI @US_078_AC_001 @SellerLogin
  Scenario: AC_001 As a user, I should create a new event
    When user clicks on My Events module on the side bar in homepage
    And user creates a new event Dilek
    And the user clicks logout button


  @UI @US_078_AC_002 @BuyerLogin
  Scenario: AC_002 As a user, I should register the event
    When the user close the  zipcode window
    And user clicks on Event
    When user clicks register button in the event at Scheduled Events
    And user sends number in number of attendee
    And user clicks Terms and conditions box approve button
    And user clicks Approve button
    And the user clicks logout button

  @UI @US_078_AC_003 @SellerLogin
  Scenario: AC_001 As a user, I should delete the event
    Given the user close the  zipcode window
    When user clicks on My Events module on the side bar in homepage
    And User goes to relevant dilek event and clicks on Delete button
    Then User should see "Event deleted" toast message


