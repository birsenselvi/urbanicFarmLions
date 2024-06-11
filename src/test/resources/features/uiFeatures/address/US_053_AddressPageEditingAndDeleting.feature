
@ela
Feature: Perform Editing and Deleting action in Address page
  Background:
    Given user goes to homepage
    When the user clicks on the Login button
    Then completes the login form with valid "email" and "password"
    Then clicks on the Login button
    Then the user enters a valid zip code
    And clicks on the GO button
@UI
  Scenario: TC_001_If addresses are added but not selected, alert will be displayed.
    Given user clicks on the address button
    Then the user clicks on add New Address button
    And the user write address in the Search Place section.
    Then clicks Submit button
    And the user clicks the My Sales Address button
    And Assert the "You haven't set your sales address yet. Please select one from your other addresses."

#  Scenario:TC_002_In the Others Address section, the address editing and deletion buttons should be operational.
    Then user clicks on the Other button
    And user assert the "Edit and Remove" button is operational.

#  Scenario: TC_003_User can corrected address with editing button and the alert should appear.
    Given the user clicks on the Edit button in the My Sales Address section
    Then the user clicks the Mark as a sales address.
    And clicks on the Submit button
    And Assert "Your address has been successfully updated" alert.

#  Scenario:TC_004_User can select Yes or No.
    Given the user clicks the My Sales Address button.
    Then the user clicks on the Remove button in the My Sales Address section
    And Assert the "Are you sure you want to delete the address?" alert.
    Then user clicks the No option and turn back to My Sales Address page.

#  Scenario:TC_005_Address can removed
    Given the user clicks on the Edit button in the My Sales Address section
    Then the user clicks the My Sales Address button
    And the user clicks on the Other button
    Given the user clicks on the Remove button in the My Sales Address section
    Then the user clicks Yes button.
    And user verifies the "Address deleted" alert.
