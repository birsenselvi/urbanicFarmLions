Feature: US004

#Farmers Market should be clickable and relevant page should be visible
  @UI @US004
  Scenario: User checks Farmers Market sign in block
    Given user goes to homepage
    And User clicks Farmers Market sign
    And User closes the pop up
    Then User verifies the page title changing



