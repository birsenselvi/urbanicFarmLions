@UI
@US_037


Feature: After registrating get Welcome message

  Scenario Outline: US_037

    Given user goes to homepage
    And user clicks register
    And user enters first name "<firstName>"
    And user enters last name "<lastName>"
    And User enters email "<email>"
    And user enters password "<password>"
    And user enters confirmPassword "<confirmPassword>"
    And user clicks reg-button
    And the user close the  zipcode window
    And user verifies that relevant page is visible
    Then user get Welcome message

    Examples:
      | firstName | lastName | email       | password    | confirmPassword |
      | Mehseti   | Umarova  | Faker class | Urbanic-123 | Urbanic-123     |


