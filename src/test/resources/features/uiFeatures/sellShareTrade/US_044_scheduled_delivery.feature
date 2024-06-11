@UI @US_44
Feature: US_44

@smoke
  Scenario: TC_001
    Given user goes to homepage
    And user logs in
  #  And user clicks on the popup
#    And the user enters a zip code
#     And clicks on the GO button
    When user clicks on Sell Share Trade
    And user clicks on the Scheduled delivery
    #Then user should see relevant page and popup
    Then user should see relevant page and url "https://test.urbanicfarm.com/account/weekly-order"