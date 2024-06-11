@UI
  @LU_215
  @LU_217
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
  @US_054
  Scenario: Editing  Delivery Address
    When the user clicks on Add New Address button
    And the user clicks on the Edit button in the Delivery Address section
    And updates the address details
    And clicks on the Submit button
    Then  user verifies the success alert "Your Address successfully updated" should appear
  Scenario: Removing Delivery Address
    When the user clicks on the Remove button in the Delivery Address section
    Then a confirmation dialog with the message "Are you sure to delete the address?" should appear
    When the user selects the No option
    And the address should still be displayed
    When the user clicks on the Remove button in the Delivery Address section again
    When the user selects the Yes option
    And a success alert saying "Address deleted" should appear





