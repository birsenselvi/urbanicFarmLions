@UI
@US_020

Feature: Footer link Blog Clicable
  Scenario:Blog link in footer clicable and open new page Welcome to the Urbanic Farm Blog
    Given  user goes to homepage
    And user scroll down to footer and clicks Blog link
    Then user validates "Welcome to the Urbanic Farm Blog" shown in new page

