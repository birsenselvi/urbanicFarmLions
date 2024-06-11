@UI @US_039
Feature: User I shouldn't be able to login with invalid login
  Background: common features for US_39
    Given user goes to the home page
    When User clicks on the login button
  Scenario:US_39-TC_001 Email address and password button should be functional

    Then User verify Email address should be functional
    Then User verify password button should be functional
  Scenario Outline:  Invalid Email and password must be entered
    And User enters an email "<email>"
    And User enters a password "<password>"
    And User clicks on the Login button
    And System clean email and password boxes
    Then After entered invalid Email, get the error messages
    Examples:
      |email                        |password      |
      |urbanicfarm1gmail.com        |Urbanicfarm1/ |
##      |urbanicfarm1@gmail.com       |Urbanicfarm1  |
#     |urbanicfarm1@gmail.com       |Urbanicfarm1/ |
#      |urbanicfarm1@yopmail.com     |Urbanicfarm1/ |
  Scenario Outline: Valid Email and invalid password must be entered
    And User enters an email "<email>"
    And User enters a password "<password>"
    And System clean email and password boxes
    And User clicks on the Login button
    Then After entered invalid password, get the toast messages
    Examples:
      |email                        |password      |
#      |urbanicfarm1gmail.com        |Urbanicfarm1/ |
      |urbanicfarm1@gmail.com       |Urbanicfarm1  |
#      |urbanicfarm1@gmail.com       |Urbanicfarm1/ |
#      |urbanicfarm1@yopmail.com     |Urbanicfarm1/ |

