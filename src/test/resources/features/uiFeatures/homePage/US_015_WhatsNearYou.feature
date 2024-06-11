@UI
@US_015

Feature: HomePage

  Background:
    Given user goes to homepage


  Scenario: US_015 Navigate to "Whats Near You" Page
    When  the user scrolls down the home page to see Whats Near You under the Reduce waste, strengthen your community heading
    And  the relevant page should open

  Scenario: US_015 - Navigate to "Post Your Goods" Page
    When  the user scrolls down the home page to see Post Your Goods under the Reduce waste, strengthen your community heading
    And the relevant page should open and visible


#  Scenario Outline: US015 Register
#    When  the user scrolls down the home page to see Post Your Goods under the Reduce waste, strengthen your community heading
#    And user enters "<First Name>","<Last Name>","<Email>","<Password>","<Confirm Password>"
#    And   user clicks reg-button
#    And user verifies the message
#    Examples:
#      | First Name | Last Name | Email             | Password | Confirm Password |
#      | Serpil     | Rainbow   | rain7@yopmail.com | Rain123!  | Rain123!          |
#      |            | Rainbow   | rain7@yopmail.com | rain123  | rain123          |
#      | Serpil     |           | rain7@yopmail.com | rain123  | rain123          |
#      | Serpil     | Rainbow   |                   | rain123  | rain123          |
#      | Serpil     | Rainbow   | rain7@            | rain123  | rain123          |
#      | Serpil     | Rainbow   | rain7@ yopmail    | rain123  | rain123          |
#      | Serpil     | Rainbow   | rain7yopmail.com  | rain123  | rain123          |
#      | Serpil     | Rainbow   | rain7@yopmailcom  | rain123  | rain123          |
#      | Serpil     |           | r@yopmail.com     | rain123  |                  |
#      | Serpil     |           | r@yopmail.com     | rain123  | rain12345        |
