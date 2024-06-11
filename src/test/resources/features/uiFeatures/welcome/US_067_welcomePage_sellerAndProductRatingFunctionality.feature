@UI
@US067
  Feature:  Seller and Product Rating functionality
 Background: Login to account
 Given user goes to homepage
 And User clicks on the login button
 And User logs in as buyer
 And the user clicks on the UrbanicFarm icon on the nowbar
 And the user clicks on the search options button
#1
 Scenario: Any Seller Rating icon should be clickable
   Then the user finds the Any seller rating icon and clicks on it

#2
 Scenario: An option from the Seller rating dropDown should be selectable
    And the user finds the Any seller rating icon and clicks on it
     Then the seller should be able to select a rating option
#3
  Scenario: Sellected Option from the Seller rating dropdown should be displayed on the screen
    And the user finds the Any seller rating icon and clicks on it
   And the user selects a rating number 5 from the dropdown menu
    Then the selected rating 5 should be visible on the screen
#4
 Scenario:  Scenario: Product Rating Icon should be clickable
     Then the user finds the Any Product rating icon and clicks on it
#5
 Scenario: An  Rating Option for products should be Selectable
   Then the user finds the Any Product rating icon and clicks on it
   Then the seller should be able to select a rating option from the product icon dropDown
#6
Scenario:The selected Rating number should be visible
   And the user finds the Any Product rating icon and clicks on it
  And the user selects a rating number 5 from the dropdown menu
  Then the selected rating 5 should be visible on the screen











