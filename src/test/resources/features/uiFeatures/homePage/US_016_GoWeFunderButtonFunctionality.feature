@UI
@US016
  Feature: Go Wefunder Button Functionality

   Background: homepage
  Given user goes to homepage
 When  user scrolls down the home page to  find the heading Invest in Urbanic Farm


    Scenario: TC01 Wefunder button should be clickable

      Then the GO WEFUNDER button should be visible and clickable

      Scenario: TC02 Relevant Page should open

        When the user clicks on the GO WEFUNDER button
        Then the user is directed to the relevant WEFUNDER page

