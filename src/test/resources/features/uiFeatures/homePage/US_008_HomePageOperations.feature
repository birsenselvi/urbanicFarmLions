Feature: Home Page Operations
  @UI @US_008
  Scenario:Login should be clickable and relevant page should be visible
    Given user goes to homepage
    Then Click on the login button
    And Confirms that the login page has been opened