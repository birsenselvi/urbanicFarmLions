@UI
  @US025
  Feature: Privacy policy link should be clickable and open the relevant page
    Background:homepage
      Given user goes to homepage
      And user scrolls down to the footer
      And the user finds the Privacy Policy link

    Scenario:TC01_Privacy_Policy_should_be_clickable

     Then the Privacy Policy link should be clickable

      Scenario: TC02_The_Privacy_Policy_Page_should_Open

        And the user clicks on the Privacy Policy link
        Then Then the ONLINE PRIVACY POLICY AGREEMENT page opens

