Feature: Register Page

  Background:
    Given user goes to homepage

  @UI
  Scenario: Register-Happy Path
    When user clicks register button on the home page
    Then The user enters first name
    And The user enters middle name
    And The user enters last name
    And The user enters email
    And The user enters password
    And The user enters confirmPassword
    And The user click the Register Button on the register page.
    Then The user see the Welcome message by a pop-up window

  @UI
  Scenario Outline:Register - Negative Testing
    When user clicks register button on the home page
    And Users enters first name "<firstName>"
    And The user enters middle name "<middleName>"
    And user enters last name "<lastName>"
    And user enters email "<email>"
    And user enters password "<password>"
    And user enters confirmPassword "<confirmPassword>"
    And The user click the Register Button on the register page.
    Then The user verifies the alert visible "<alert>" and "<xPath>"

    Examples:
      | xPath                                       | firstName | lastName | middleName | email          | password        | confirmPassword | alert                                                                 |
      | //input[@id='registration_form_firstname']  | 12        | John     | Hill       | john@gmail.com | Urbanicfarm.123 | Urbanicfarm.123 | Please match the format requested.                                    |
      | //input[@id='registration_form_firstname']  | .,        | John     | Hill       | john@gmail.com | Urbanicfarm.123 | Urbanicfarm.123 | Please match the format requested.                                    |
      | //input[@id='registration_form_firstname']  |           | John     | Hill       | john@gmail.com | Urbanicfarm.123 | Urbanicfarm.123 | Please fill in this field.                                            |
      | //input[@id='registration_form_lastname']   | Lily      | 13       | Hill       | john@gmail.com | Urbanicfarm.123 | Urbanicfarm.123 | Please match the format requested.                                    |
      | //input[@id='registration_form_lastname']   | Lily      | ?>       | Hill       | john@gmail.com | Urbanicfarm.123 | Urbanicfarm.123 | Please match the format requested.                                    |
      | //input[@id='registration_form_lastname']   | Lily      |          | Hill       | john@gmail.com | Urbanicfarm.123 | Urbanicfarm.123 | Please fill in this field.                                            |
      | //input[@id='registration_form_middlename'] | Lily      | John     | 56         | john@gmail.com | Urbanicfarm.123 | Urbanicfarm.123 | Please match the format requested.                                    |
      | //input[@id='registration_form_middlename'] | Lily      | John     | _+         | john@gmail.com | Urbanicfarm.123 | Urbanicfarm.123 | Please match the format requested.                                    |
      | //input[@id='registration_form_email']      | Lily      | John     | Hill       | }:@gmail.com   | Urbanicfarm.123 | Urbanicfarm.123 | A part followed by '@' should not contain the symbol ':'.             |
      | //input[@id='registration_form_email']      | Lily      | John     | Hill       | .com           | Urbanicfarm.123 | Urbanicfarm.123 | Please include an '@' in the email address. '.com' is missing an '@'. |
      | //input[@id='registration_form_email']      | Lily      | John     | Hill       | @gmail.com     | Urbanicfarm.123 | Urbanicfarm.123 | Please enter a part followed by '@'. '@gmail.com' is incomplete.      |

  @UI
  Scenario Outline: Register -First Name Edge Cases
    When user clicks register button on the home page
    And  User enters first name <firstname>
    And The user enters middle name "<middleName>"
    And user enters last name "<lastName>"
    And The user enters email
    And user enters password "<password>"
    And user enters confirmPassword "<confirmPassword>"
    And The user click the Register Button on the register page.
    Then  The user verifies the alert visible firstName "<alert>"

    Examples:
      | firstname | middleName | lastName | password        | confirmPassword | alert                                                                                    |
      | 1         | John       | Hill     | Urbanicfarm.123 | Urbanicfarm.123 | Please lengthen this text to 2 characters or more (you are currently using 1 character). |
      | 500       | John       | Hill     | Urbanicfarm.123 | Urbanicfarm.123 |                                                                                          |
      | 501       | John       | Hill     | Urbanicfarm.123 | Urbanicfarm.123 |                                                                                          |

  @UI
  Scenario Outline: Register -Last Name Edge Cases
    When user clicks register button on the home page
    And user enters first name "<firstName>"
    And The user enters middle name "<middleName>"
    And user enters last name <lastName>
    And The user enters email
    And user enters password "<password>"
    And user enters confirmPassword "<confirmPassword>"
    And The user click the Register Button on the register page.
    Then  The user verifies the alert visible lastName "<alert>"

    Examples:
      | firstName | middleName | lastName | password        | confirmPassword | alert                                                                                    |
      | Hill      | John       | 1        | Urbanicfarm.123 | Urbanicfarm.123 | Please lengthen this text to 2 characters or more (you are currently using 1 character). |
      | Hill      | John       | 500      | Urbanicfarm.123 | Urbanicfarm.123 |                                                                                          |
      | Hill      | John       | 501      | Urbanicfarm.123 | Urbanicfarm.123 |                                                                                          |













