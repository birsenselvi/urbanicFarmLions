@BuyerLogin
Feature: Welcome Page Orders

  Background: go to welcome page
    Given user clicks on Urbanic Farm icon on the left hand side of home page
    Then user should navigate to welcome page


  @UI @TC001
  Scenario: There must be a list of sellers and they must be selectable
    Then user should see the list of sellers on the page
    When user clicks on any seller next to any order (selectable)
    Then user should go to the sellers page

  @UI @TC002 @US068
  Scenario: User must be able to see product categories
    Then user should be able to see all product categories under categories dropdown
      | Any                        |
      | Vegetables & fruits        |
      | Dairy                      |
      | Gardening Services         |
      | Gardening supplies & tools |
      | Seed                       |
      | Seedling & Sapling         |
      | Compost                    |
      | Worm                       |
      | Fertilizer                 |
      | Trees                      |
      | Herbs & Flowers            |
      | Microgreens                |

    When user selects a product from categories
    Then selected category list should be displayed in the page

  @UI @TC003
  Scenario: user must be able to add a product from welcome page
    Then Product quantity icons + - should be functional
    Then Add to cart button should be functional
   When user clicks on Add to cart button for first product in the list
   Then user should see a toast message product " added to your basket!"


