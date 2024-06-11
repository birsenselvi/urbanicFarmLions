@UI @SellerLogin @US_077
Feature: My Events,As a user, should not able to add an address successfully by providing with invalid data

  Background:
   Given user clicks on My Events module on the side bar in homepage
   And user clicks on the Create New Event

  Scenario: US_077 TC_001 title should be at least two character if so user will see warning message "Please enter a valid title."
    And user enters a character in the Title* box and fills other input boxes out
    And user clicks on submit button
    Then user should see warning message "Please enter a valid title." under Title box

  Scenario: US_077 TC_002 title can not be blank if so user will see warning message "Please enter a valid title."

    And user leaves blank in the Title box and fills other input boxes out
    And user clicks on submit button
    Then user should see warning message "Please enter a valid title." under Title box

  Scenario: US_077 TC_003 address should be at least one character and can not be blank if so user will see warning message "Please enter a valid address."

    And user leaves blank in the Address* box and fills other input boxes out
    And user clicks on submit button
    Then user should see warning message "Please select an address." under Address box

  Scenario: US_077 TC_004 User should be able to add date. can not be blank if so user will see warning message "Please fill in this field."

    And user leaves blank in the Date* box and fills other input boxes out
    And user clicks on submit button
    And user should see warning message "Please fill in this field." under Date box

Scenario: US_077 TC_005 User should be able to add time. can not be blank if so user will see warning message "Please fill in this field."

    And user leaves blank  in the Time* box and fills other input boxes out
    And user clicks on submit button
    And user should see warning message "Please fill in this field." under Time box


