@UI @SellerLogin @US082
Feature: Notification button in events page

  Background:
    Given user clicks on My Events module on the side bar in homepage
    And user creates a new event
    And user refreshes the page
    And user clicks on Notification icon on navbar

  Scenario: User must be able to do various actions on Notification
    Then user should see the notification page
    Then "Mark Read" should be seen on the radio button of the new notification
    And "Mark Unread" should be seen on the radio button of the new notification
    Then "Mark all as read" should be seen on top of the page
    Then "Filter by unread" should be seen on top of the page
    When user clicks on Mark all as read
    Then user should see "View all"
    Then user verifies that "No unread notifications" is seen
    When user clicks on close notification icon
    And user deletes the event
