@UI
@US_031
Feature: Verify LinkedIn icon functionality

  Scenario: US031

    Given user goes to homepage
    When User scroll down footer
    And the user clicks the LinkedIn icon
    And the user close the  window
    And the user should be redirected to the LinkedIn page


