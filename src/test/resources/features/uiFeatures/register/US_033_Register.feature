Feature: US_033
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






