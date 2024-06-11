@UI @SellerLogin
 Feature: The Functionality Of Cancle, Complete and CopyLinkButtons

 Background: logingin to create an evet
     Given user clicks on My Events module on the side bar in homepage
     And user creates an event

    Scenario: User Cancels an Event
     When the user clicks on the Cancel button
     And a confirmation pop-up should appear asking Are you sure you want to cancel this event?
     And the user confirms by clicking Yes
     Then the Cancelled Message should be visible
     And the event status should be updated to Cancelled

   Scenario: User Marks an Event as Completed
     When the user clicks on the Mark as Completed button
     Then a message should appear stating Event marked as completed


   Scenario:  User Copies Event Link
      When the user clicks on the Copy Link button
      Then a message should appear stating "Event Link Copied to Clipboard"

   Scenario: User changes their mind to cancel the event
     When the user clicks on the Cancel button
     And a confirmation pop-up should appear asking Are you sure you want to cancel this event?
     Then the user decides to keep the event by clicking on "No"
     And the event remains visible with the "New" label on it