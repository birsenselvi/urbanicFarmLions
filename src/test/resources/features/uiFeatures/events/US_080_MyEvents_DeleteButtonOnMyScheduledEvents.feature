@UI @US_080 @SellerLogin
Feature: US_080 As a user, should able to delete event on Scheduled Events page by clicking Delete button

  Background:
    Given user clicks on My Events module on the side bar in homepage
    And user clicks on My Scheduled Events button
    And user creates a new event for USA
    And User goes to relevant events and clicks on Delete button

  @US_080_TC01
  Scenario: Are you sure you want to delete this event ? PopUp Message
    Then User should see popup message
      | PopUp Message                                |
      | Are you sure you want to delete this event ? |

    @US_080_TC02
    Scenario: Verify "No" button
      Then User verifies that there is "No" button after clicking delete button

    @US_080_TC03
    Scenario: Event Deleted Pop Up Message - E2E Test
      When User deletes relevant event
      Then User should see "Event deleted" toast message

    @US_080_TC04
    Scenario: Event should not be on the list of My Scheduled Events - E2E Test
      When User deletes relevant event
      Then The event should not be on the list of My Scheduled Events


