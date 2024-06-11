@UI @US_064 @LU-187 @smokeNihan
Feature: Perform various actions in the Orders section

  Background: Orders
    Given user goes to home page and logs in with different ENUM
    When user goes farmers market

  @LU-167 @smoke
  Scenario: TC_001 Orders option should be clickable
    Then user verifies the Order button is clickable

  @LU-168
  Scenario: TC_002 Clicking on Orders should display the Your Orders(Orders List) page
    And user clicks Orders button from dropdown menu
    Then user verifies to see relevant page is visible is Order List

  @LU-180
  Scenario: TC_003 Any order must be selected
    And user clicks Orders button from dropdown menu

  @LU-169
  Scenario: TC_004 Various content related to the order should be seen in the Order Quick Overview field.
    And user clicks Orders button from dropdown menu
    Then user verifies to see Order QuickOverview field

  @LU-170
  Scenario: TC_005 Product Name, Price, Stock, Unit, Image should be seen
    And user clicks Orders button from dropdown menu
    Then user verifies to see Product Name, Price, Stock, Unit, Image should be seen

  @LU-169
  Scenario:TC_006 Rate the product icon must be functional
    And user clicks Orders button from dropdown menu
    Then verify Rate the product button is  functional

  @LU-172
  Scenario:TC_007 Rate the product, Rate The Seller buttons should be clickable
    And user clicks Orders button from dropdown menu
    And click View order detail and then click Rate The Seller
    Then assert Rate the Seller is clickable

  @LU-173
  Scenario: TC_008 When the Rate the product, Rate The Seller buttons are clicked, various actions should be performed on the screen that opens
    And user clicks Orders button from dropdown menu
    And click View order detail and then click Rate The Seller
    And check rating stars
    Then user verifies that verify Rate the Seller screen is opened
