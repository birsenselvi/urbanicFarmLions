@BuyerLogin  @UI
Feature: Welcome Page Products in Basket

  Background: go to welcome page
    When user clicks on Urbanic Farm icon on the left hand side of home page
    Then user should navigate to welcome page
    When user clicks on Add to cart button for first product in the list
    And user clicks on Cart

  @US_069 @TC001
  Scenario: user must be able to increase the quantity of product in the basket
    When user clicks on + sign under quantity of product
    Then quantity of product should be increased

#  @UI @US_069 @TC002
#  Scenario: total price must change when the quantity of product is increased in the basket
#    When user clicks on + sign under quantity of product
#    Then user verifies that total price has changed accordingly.
 # @UI @TC003
#  Scenario: User must see a warning message when deleting a product in the basket
#    When user clicks on red x sign
#    Then user should see warning message "Are you sure you want to delete the product?"
#    When user clicks No button
#    Then user should not delete the product
#    When user clicks on red x sign
#    And user clicks on Yes button
#    Then user should see a message after deleting the product
#
