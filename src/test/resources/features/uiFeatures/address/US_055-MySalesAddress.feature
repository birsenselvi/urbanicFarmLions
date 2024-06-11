@UI
  @US_055
  @LU_228
  @LU_229

Feature: Address Management

  Background:
    Given user goes to homepage
    When the user clicks on the Login button
    Then completes the login form with valid "email" and "password"
    Then clicks on the Login button
    Then the user enters a valid zip code
    And clicks on the GO button
    Given user clicks on the address button

  @UI
  @US_055
  Scenario: Editing My Sales Address
    When the user clicks on Add New Address button for My Sales Address
    And the user clicks on the Edit button in the My Sales Address section
    And updates the address details
    And clicks on the Submit button
    Then  user verifies the success alert "Your Address successfully updated" should appear
  Scenario: Removing Delivery Address
    When the user clicks on the Remove button in the My Sales Address section
    Then a confirmation dialog with the message "Are you sure to delete the address?" should appear
    When the user selects the No option
