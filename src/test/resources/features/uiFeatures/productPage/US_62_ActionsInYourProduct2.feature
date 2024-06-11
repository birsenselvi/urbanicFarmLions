Feature:Your products/services

  @UI @US_062 @DB
  Scenario:
    Given user goes to homepage
    When  user logs in as a Buyer
    Then user goes to Your products-services
    When user click on random Hubs
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
    Then user clicks Update button
    And user verifies that Updated alert is visible
    When user proceeds forward, retrieves the count of products in the list, then returns back
    When user clicks Delete button
    And user verifies that Yes options is visible
    And user verifies that No options is visible
    And user selects no option and verifies that No option cancel the operation
    When user selects the Yes option and verifies that the last added product has been removed
    Then user verifies that deleting alert is displayed


