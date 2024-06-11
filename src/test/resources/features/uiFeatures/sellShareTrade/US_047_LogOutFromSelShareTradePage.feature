@UI
  @US047

Feature: LogOut from "Sell_Share_Trade" Page Redirects to Relevant Page

  Background: Sell-Share-Trade Page
    Given user goes to home page and logs in
  And the user clicks onto the Sell-Share-Trade button

  Scenario:TC01_The_LogOutButton_shuold_be_clickable
  Then  the user clicks onto the logout button

Scenario: TC02_The relevant page should open and visible
  Then  the user clicks onto the logout button
  Then the relevant page with a  header Join the Movement! should apear

