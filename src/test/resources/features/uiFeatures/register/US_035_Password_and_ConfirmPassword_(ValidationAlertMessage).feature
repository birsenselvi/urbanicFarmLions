Feature: US035

  #password should not be left blank
  #A alert should appear when an invalid password is entered: Must contain at least one number and uppercase and lower case letter, and aty least 8 or more characters
  #Confirm password and password must match
  #An alert should appear when the confirmation password and the password do not match: Please match the requested format

  @UI
  Scenario Outline: AC001 User checks password boxes in register part
    Given user goes to homepage
    When   user clicks register
    And user enters first name "<firstName>"
    And user enters last name "<lastName>"
    And User enters email "<email>"
    And   user enters password "<password>"
    And   user enters confirmPassword "<confirmPassword>"
    And   user clicks reg-button
    Then  user verifies the alert visible "<alert>"
    Examples:
      | firstName | lastName | email             | password | confirmPassword | alert                              |
      | dilek     | yilmaz   | dilek@yopmail.com |          | 1234567         | Please fill in this field          |
      | dilek     | yilmaz   | dilek@yopmail.com | 1234567  | 1234567         | Please match the format requested. |
      | dilek     | yilmaz   | dilek@yopmail.com | 12345678 | 1234567         | Please match the format requested. |
  @UI
  Scenario Outline: AC002 User checks confirm password boxes in register part
    Given user goes to homepage
    When   user clicks register
    And user enters first name "<firstName>"
    And user enters last name "<lastName>"
    And User enters email "<email>"
    And   user enters password "<password>"
    And   user enters confirmPassword "<confirmPassword>"
    And   user clicks reg-button
    Then  user verifies the confirm box alert visible "<alert>"
    Examples:
      | firstName | lastName | email             | password | confirmPassword | alert                              |
      | dilek     | yilmaz   | dilek@yopmail.com | 1234AaBB | 1234567         | Passwords Don't Match              |
      | dilek     | yilmaz   | dilek@yopmail.com | 1234AaBB | 12345678        | Passwords Don't Match              |

