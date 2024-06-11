@UI @US050
Feature: Checking various actions on Account Page

  Background:
    Given user goes to home page and logs in
    Then Account module should be clickable
    When user clicks on Account module on the left hand side of Home page

  @UI @TC001 @US050
  Scenario: User should be able see full name,email,QR code and edit button after clicking
  Account module on the left hand side of Home page
    Then user should be navigated to the account page
    And user should be able to see full name,email,QR code and edit button on this page

  @TC002 @UI
  Scenario: Copy and Download button on Account Page should be functional
    Then Copy button should be functional
    And Download Button should be functional

  @TC003 @UI
  Scenario: After clicking Edit button Choose file button should be functional
    When user clicks on Edit button on this page
    Then user verifies that choose file button is functional

  @TC004 @UI
  Scenario: User should be able to upload a file after clicking Choose file button
    Then user verifies that Edit button is functional
    When user clicks on Edit button on this page
    And user uploads an image thorough Choose file
    And user clicks on Save button
    Then user verifies that image was uploaded successfully
    Then user verifies that account picture has been changed

  @TC005 @UI
  Scenario: User should be able to update phone number(Negative1)
    When user clicks on Edit button on this page
    And user enters an invalid phone number
    Then user should be able to see "Invalid phone number:"

  @TC006 @UI
  Scenario: User should be able to update phone number(Negative2)
    When user clicks on Edit button on this page
    And user enters many zeros to  phone number input
    Then warning message should contain "missing country code"

  @TC007 @UI
  Scenario: User should be able to update phone number(Positive)
    When user clicks on Edit button on this page
    And user enters a valid phone number
    Then Save button should be functional
    When user clicks on Save button
    Then "Your account information has been updated." alert should be displayed.
    Then user verifies that phone number has been updated

    @TC008 @UI
      Scenario: Toggle menu should be working as expected
      Then toggle menu should be functional on account page
      When user clicks on toggle menu
      Then menu dimensions should be changed














