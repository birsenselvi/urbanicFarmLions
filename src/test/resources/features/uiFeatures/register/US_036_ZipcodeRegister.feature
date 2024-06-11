@UI @US_036
Feature: User Registration with 5-Digit Zipcode Validation
  Scenario Outline: User enters zipcode during registration
    Given user goes to the home page
    Given user goes to homepage
    When   user clicks register
    And user enters first name "<firstName>"
    And user enters last name "<lastName>"
    And User enters email "<email>"
    And   user enters password "<password>"
    And   user enters confirmPassword "<confirmPassword>"
    When user scrolls down
    And user enters a zipcode "<zipcode>"
    And   user clicks reg-button
    #Then verify that zipcode enteries match the expected results
    Examples:
    |zipcode|
    |       |
    |0701   |
    |070134 |
    |07013  |

#    |zipcode|expected result|
#    |empty  | Pass          |
#    |0701   | Pass          |
#    |070134 | Pass          |
#    |07013  | Pass          |








