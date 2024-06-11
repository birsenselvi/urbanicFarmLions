@US_059

Feature: User checks all menus should be functional in seller delivers the products area

  Background: Login to delivery settings
    Given user goes to homepage
    When user logs in as a seller
    And user clicks on the delivery pickup settings
    And user clicks Seller delivers the products section

  @UI @US_059_AC_001 @smoke
  Scenario: As a user, when I enter the Delivery and Pick up settings all functions should be clickable
    Then User verifies that the following web elements are visible and functional
      | freeDeliveryRangeProduct             |
      | minOrderAmountForFreeDeliveryProduct |
      | perMileCostProduct                   |
      | maxDeliveryRangeProduct              |
      | estimatedDeliveryTimeProduct         |
      | upToMileProduct                      |
      | sellerFlexible                       |
      | Update                               |


  @UI @US_059_AC_002
  Scenario Outline:US_059_AC_002 User checks that free Delivery Range (mile) should be 0-1000
    And User types  "<freeMile>" in free Delivery Range mile
    And User clicks update button
    Then User verifies the "<alertMessage>" in free Delivery Range mile box
    And the user clicks logout button
    Examples:
      | freeMile | alertMessage                              |
      |          | Please fill in this field                 |
      | -1       | Value must be greater than or equal to 0. |
      | 1001     | Value must be less than or equal to 1000. |

  @UI @US_059_AC003
  Scenario Outline:US_059_AC_003 User checks that minimum Order Amount For Free Delivery($) should be 0-10000.
    And User types  "100" in free Delivery Range mile
    And User types  "<minOrder>" in minimum Order Amount For Free Delivery $ box
    And User clicks update button
    Then User verifies the "<alertOrder>"
    And the user clicks logout button
    Examples:
      | minOrder | alertOrder                                 |
      |          | Please fill in this field                  |
      | -15      | Value must be greater than or equal to 0.  |
      | 10001    | Value must be less than or equal to 10000. |

  @UI @US_059_AC004
  Scenario Outline:US_059_AC_004 User checks that Per Mile Cost ($) should be 0-5.
  Alert should be seen on different selections
    And User types  "100" in free Delivery Range mile
    And User types  "500" in minimum Order Amount For Free Delivery $ box
    And User types  "<minCostMile>" in Per Mile Cost $ box
    And User clicks update button
    Then User verifies the "<alertOrder>" in Per Mile Cost $ box
    And the user clicks logout button
    Examples:
      | minCostMile | alertOrder                                |
      |             | Please fill in this field                 |
      | -1          | Value must be greater than or equal to 0. |
      | 8           | Value must be less than or equal to 5.    |

  @UI @US_059_AC005
  Scenario Outline:US_059_AC_005 User checks that Maximum Delivery Range (mile) should be 0-1000.
  Alert should be seen on different selections
    And User types  "100" in free Delivery Range mile
    And User types  "500" in minimum Order Amount For Free Delivery $ box
    And User types  "3" in Per Mile Cost $ box
    And User types  "<maxDeliveryRange>" in Maximum Delivery Range mile box
    And User clicks update button
    Then User verifies the "<alert>" in Maximum Delivery Range mile box
    And the user clicks logout button
    Examples:
      | maxDeliveryRange | alert                                     |
      | -1               | Value must be greater than or equal to 0. |
      | 1001             | Value must be less than or equal to 1000. |

  @UI @US_059_AC006
  Scenario:US_059_AC_006 User checks that An appropriate option must be selected from the Estimated Delivery Time menu.
    And User types  "100" in free Delivery Range mile
    And User types  "500" in minimum Order Amount For Free Delivery $ box
    And User types  "3" in Per Mile Cost $ box
    And User types  "300" in Maximum Delivery Range mile box
    And user types "100" in the Up to mile menu
    And user clicks the Estimated Delivery Time box
    Then user verifies the Estimated Delivery Time menu visible and selectable

  @UI @US_059_AC007
  Scenario:US_059_AC007 A number must be entered in the Up to (mile) menu
    And User types  "100" in free Delivery Range mile
    And User types  "500" in minimum Order Amount For Free Delivery $ box
    And User types  "3" in Per Mile Cost $ box
    And User types  "300" in Maximum Delivery Range mile box
    And user types "100" in the Up to mile menu
    And user selects Estimated Delivery Time
    And User clicks update button
    Then user verifies that "Your delivery settings have been successfully updated" alert message appear

