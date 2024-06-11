#Delivery type-Seller flexible delivery
#All menus in the relevant area should be functional and appropriate options should be selected.
#Free Delivery Range (mile) should be 0-1000. Alert should be seen on different selections
#Minimum Order Amount For Free Delivery($) should be 0-10000. Alert should be seen on different selections
#Per Mile Cost ($) should be 0-5. Alert should be seen in different selections
#Maximum Delivery Range (mile) should be 0-1000. Alert should be seen on different selections
#A suitable day must be selected for the Order Begin menu.
#Time menu should work correctly
#A suitable day must be selected for the Order End menu.
#Time menu should work correctly
#A suitable day must be selected for the Deliver By menu
#Time menu should work correctly
#Your delivery settings have been succesfully updated alert should appear
  # @lu-287 test execution no => jiradan geliyor
@UI @us60 @LU-287
Feature: Us_60 Seller flexible delivery

  Background: Seller flexible
    Given user goes to homepage
    When user logs in as a seller
    And user clicks on the delivery pickup settings
    And user clicks on the Seller flexible delivery
  @TEST_LU-286
  Scenario: TC_001 All menu check(visibility and functionnality)
    Then user verify that the following web elements are visible and functionnel
      | freeFlexibleDeliveryRange | minFreeFlexibleDeliveryOrder | perMileCostFlex | maxFlexibleDeliveryRange | _deliveryBeginDay | _deliveryBeginTime | _deliveryEndDay | _deliveryEndTime | _orderByDay | _orderByTime |
  @TEST_LU-288
  Scenario: TC_002 Data inputs for free delivery range
    When user enters number to free delivery range and asserts border color and alerts


      | -1        | rgba(255, 0, 0, 0.25) 0px 0px 0px 4px    | Value must be greater than or equal to 0. |
      | -0.00001  | rgba(255, 0, 0, 0.25) 0px 0px 0px 4px    | Value must be greater than or equal to 0. |
      | 0         | rgba(13, 110, 253, 0.25) 0px 0px 0px 4px |                                           |
      | 1         | rgba(13, 110, 253, 0.25) 0px 0px 0px 4px |                                           |
      | 300       | rgba(13, 110, 253, 0.25) 0px 0px 0px 4px |                                           |
      | 999       | rgba(13, 110, 253, 0.25) 0px 0px 0px 4px |                                           |
      | 1000      | rgba(13, 110, 253, 0.25) 0px 0px 0px 4px |                                           |
      | 1000.0001 | rgba(255, 0, 0, 0.25) 0px 0px 0px 4px    | Value must be less than or equal to 1000. |
      | 1001      | rgba(255, 0, 0, 0.25) 0px 0px 0px 4px    | Value must be less than or equal to 1000. |


  @TEST_LU-289
  Scenario: TC003_Data inputs for Minimum Order Amount For Free Delivery($)
    When user enters number to Minimum Order Amount For Free Delivery and asserts border color and alerts
      | -1         | 20 | Cette valeur doit être supérieure ou égale à 0.     |
      | -0.00001   | 30 | Cette valeur doit être supérieure ou égale à 0.     |
      | 0          |    | Please fill out this field.                         |
      | 1          |    | Please fill out this field.                         |
      | 300        |    | Please fill out this field.                         |
      | 9999       |    | Please fill out this field.                         |
      | 10000      |    | Please fill out this field.                         |
      | 10000.0001 | 10 | Cette valeur doit être inférieure ou égale à 10000. |
      | 10001      | 15 | Cette valeur doit être inférieure ou égale à 10000. |
  @TEST_LU-302
  Scenario: TC004_Data inputs for Per Mile Cost ($)
    When user enters number to Per Mile Cost  and asserts border color and alerts
      | -1 | Cette valeur doit être supérieure ou égale à 0. |
      | 0  |                                                 |
      | 1  |                                                 |
      | 5  |                                                 |
      | 6  | Cette valeur doit être inférieure ou égale à 5. |
  @TEST_LU-303
  Scenario: TC005_Data inputs for max delivery Range (mile) )
    When user enters number to max delivery Range (mile)  and asserts border color and alerts
      | -1        | rgba(255, 0, 0, 0.25) 0px 0px 0px 4px    | Cette valeur doit être supérieure ou égale à 0.    |
      | -0.00001  | rgba(255, 0, 0, 0.25) 0px 0px 0px 4px    | Cette valeur doit être supérieure ou égale à 0.    |
      | 0         | rgba(13, 110, 253, 0.25) 0px 0px 0px 4px |                                                    |
      | 1         | rgba(13, 110, 253, 0.25) 0px 0px 0px 4px |                                                    |
      | 300       | rgba(13, 110, 253, 0.25) 0px 0px 0px 4px |                                                    |
      | 999       | rgba(13, 110, 253, 0.25) 0px 0px 0px 4px |                                                    |
      | 1000      | rgba(13, 110, 253, 0.25) 0px 0px 0px 4px |                                                    |
      | 1000.0001 | rgba(255, 0, 0, 0.25) 0px 0px 0px 4px    | Cette valeur doit être inférieure ou égale à 1000. |
      | 1001      | rgba(255, 0, 0, 0.25) 0px 0px 0px 4px    | Cette valeur doit être inférieure ou égale à 1000. |
  @TEST_LU-304
  Scenario Outline: TC006_Time and Day
    When user selects "<orderBegin>" for orderBegin
    And user enters input to order begin "<beginTime>"
    And user selects "<orderEnd>" for orderEnd
    And user enters input to order end "<endTime>"
    And user selects "<deliverBy>" for deliverBy
    And user enters input to deliver by "<deliverTime>"
    And user clicks on update button
    Then user verifies the toast message is "<toastMessage>"
    Scenarios:
      | orderBegin | beginTime | orderEnd | endTime | deliverBy | deliverTime | toastMessage                                                                     |
      | 1          | 0230pm    | 1        | 0230pm  | 6         | 0306pm      | At the 1. line, The end time of order must be later than the start time of order |
      | 1          | 0230pm    | 1        | 0130pm  | 6         | 0306pm      | At the 1. line, The end time of order must be later than the start time of order |
      | 3          | 0230pm    | 2        | 0230pm  | 6         | 0306pm      | At the 1. line, The end time of order must be later than the start time of order |
      | 3          | 0230pm    | 4        | 0330pm  | 6         | 0306pm      | Your delivery settings have been successfully updated                            |



