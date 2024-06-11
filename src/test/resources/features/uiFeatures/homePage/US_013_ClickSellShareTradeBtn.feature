@UI
@US_013
Business Need: User clicks Sell,Share,Trade button

  Scenario: US_013

    Given user goes to homepage
    When User clicks Sell button
    And User back to homepage
    And User clicks Share button
    And User back to homepage
    And User clicks Trade button
    Then User verifies that relevant page is displayed