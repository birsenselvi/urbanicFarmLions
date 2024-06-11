@UI @US_057
Feature: US_057 Buyer picks up on the vine button

  Background:
    Given User goes to the homepage
    When User logs in and goes to the delivery pickup settings
    When User clicks on the Buyer picks up on the vine checkbox button

  @US_057_TC01
  Scenario: Buyer picks up on the vine button
    Then Verify that Buyer picks up on the vine button should be clickable


  @US_057_TC02
  Scenario:  Your available hours menu
    Then Verify that Your available hours menu is functional and visible


  @US_057_TC03
  Scenario Outline:  Start time cannot be greater than end time at the Buyer picks up on the vine field." message
    When User chooses "<startTime>" and "<endTime>" for start and end time
    And User clicks on update button
    Then Verify that the alert message is "<alertMessage>"
    Scenarios:
      | startTime | endTime | alertMessage                                                                        |
      | 12:00     | 13:00   | Your delivery settings have been successfully updated                               |
      | 13:00     | 13:00   | Start and end time cannot be same at the Buyer picks up on the vine field.          |
      | 14:00     | 13:00   | Start time cannot be greater than end time at the Buyer picks up on the vine field. |


  @US_057_TC04 @smoke
  Scenario: suitable hours should be selected from the menu
    Then Verify that start and end time and alert message
      | StartTime | EndTime | AlertMessage                                                                        |
      | 12:00     | 13:00   | Your delivery settings have been successfully updated                               |
      | 13:00     | 13:00   | Start and end time cannot be same at the Buyer picks up on the vine field.          |
      | 14:00     | 13:00   | Start time cannot be greater than end time at the Buyer picks up on the vine field. |


