@UI @US_061 @LU-291 @DB
Feature: Your products/services


  @Test_LU-290
  Scenario: TC_01 As a user, after entering valid information, I should be able to perform various actions in the Your products/services section
    Given user goes to homepage
    When  user logs in as a Buyer
    And user goes to Your products-services
    And user click on random Hubs
    And user verifies that Product Name, Price, Stock, Unit information  is displayed.
    And user verifies that APPROVED, IN_REVIEW, REJECTED options for each product should be visible
    And user add new product
    Then In-Review should be visible on the added product.
    When User approve last added product from database
    Then Approved should be visible on the added product.
    When user clicks previously added product name
    And user verifies that Update button is visible
    And user verifies that Delete button is visible
    And user verifies that Trade button is functional
    And user verifies that Trade description is visible
    And user sends Selam to Trade input  description
    And user changes Price,Stocks,Unit type
    And user clicks Update button
    Then user verifies that Updated alert is visible

