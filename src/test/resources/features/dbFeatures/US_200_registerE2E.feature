#As a user, when i should sign up then Should be able to see new user
# information in the correct user schema and columns
#"Correct infos need to be seen in the correct columns.
#I should see user informations in the correct columns, eg : email."

@dbRegression
  Feature: US_200
    @UI
Scenario Outline:TC_001 - Name, Lastname, Email, Password fields must be functional
Given user goes to homepage
And user clicks register button on the home page
Then The user enters first name "<firstName>"
Then The user enters last name "<lastName>"
Then The user enters email "<email>"
And The user enters password "<password>"
And The user enters confirmPassword "<confirmPassword>"
And The user click the Register Button on the register page.
Examples:
| firstName | lastName | email             | password      | confirmPassword |
| Andrew    | Mountain | andrewm@gmail.com | Urbanicfarm1/ | Urbanicfarm1/   |

@DB
  Scenario: TC_002
    Given user verifies following column names are present in "user" table
      | email      |
      | first_name |
      | id         |
    Then user verifies the added user exists
   #And user deletes last record