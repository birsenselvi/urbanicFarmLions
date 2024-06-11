@UI
  @US066
Feature: Verfy Welcome Page appearance
  Background:
    Given user goes to homepage
    And User clicks on the login button
    And User logs in as buyer
    And the user clicks on the UrbanicFarm icon on the nowbar
#1
  Scenario: User successfully logs in and the Welcome Page appears
    Then the Welcome Page should appear
#2
  Scenario:  What are you looking for icon is visible and functional
    Then the What are you looking for icon should be visible and functional
#3
Scenario: "Search in miles" icon is visible and functional
    Then the Search in miles icon should be visible and functional
  #4
  Scenario: visibility and functionality of categories icon
    Then the categories icon should be visible and funtional
#5
  Scenario:  "Only in organic Produce" icon is visible and functional
    Then the Only in organic Produce option should be visible and functional
#6
Scenario:  User performs a search and information about price is visible
  When the user searches for an item from the What Are you Looking For search box
  And the user selects a distance from the Search in miles dropdown menu
  And the user selects a category from the Categories dropdown menu
  And the user switches to the option Only in organic Produce
  And the user clicks on the Search button
  Then information about price should be visible
#7
  Scenario: User performs a search and delivery type options are visible
    When the user searches for an item from the What Are you Looking For search box
    And the user selects a distance from the Search in miles dropdown menu
    And the user selects a category from the Categories dropdown menu
    And the user switches to the option Only in organic Produce
    And the user clicks on the Search button
    Then delivery type options should be visible

    #8
  Scenario: Unit type should be displayed
    When the user searches for an item from the What Are you Looking For search box
    And the user selects a distance from the Search in miles dropdown menu
    And the user selects a category from the Categories dropdown menu
    And the user switches to the option Only in organic Produce
    And the user clicks on the Search button
    Then unit type options should be visible

    #9
  Scenario: User performs a search and the correct results are displayed
    When the user searches for an item from the What Are you Looking For search box
    And the user selects a distance from the Search in miles dropdown menu
    And the user selects a category from the Categories dropdown menu
    And the user switches to the option Only in organic Produce
    And the user clicks on the Search button
    Then the displayed search results should match the selected criteria








