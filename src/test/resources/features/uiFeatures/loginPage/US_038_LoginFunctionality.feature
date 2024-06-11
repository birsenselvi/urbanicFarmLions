@UI @US_038
  Feature:As a user I should be able to login with my valid account
    Scenario: US_038 TC_001 Email address and password button should be functional
      Given user goes to the home page
      When User clicks on the login button
      Then User verify Email address should be functional
      Then User verify password button should be functional
    Scenario Outline: Email and password must be entered
      Given user goes to the home page
      When User clicks on the login button
      And User enters an email "<email>"
      And User enters a password "<password>"
      And System clean email and password boxes
      Examples:
      |email                        |password      |
      |urbanicfarm1gmail.com        |Urbanicfarm1/ |
      |urbanicfarm1@gmail.com       |Urbanicfarm1  |
      #|urbanicfarm1@gmail.com       |Urbanicfarm1/ |
      #|urbanicfarm1@yopmail.com     |Urbanicfarm1/ |
    Scenario Outline: Email and password must be entered
      Given user goes to the home page
      When User clicks on the login button
      And User enters an email "<email>"
      And User enters a password "<password>"
      #And System clean email and password boxes
      Then When it is clicked Login button and relevant page should be displayed.
      Examples:
        |email                        |password      |
        |urbanicfarm1gmail.com        |Urbanicfarm1/ |
        |urbanicfarm1@gmail.com       |Urbanicfarm1  |



      