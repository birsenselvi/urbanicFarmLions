@UI
Feature: As a user, I should be able to perform various operations on the Contact us page

  Scenario: TC01 Contact Us Title Visibility

    Given user goes to the home page
    When The Contact Us banner at the top of the Welcome Page should be visible and clickable.
    Then Closes the page.

    Scenario: TC02 Empty Information Sending Status

      Given user goes to the home page
      When The Contact Us banner at the top of the Welcome Page should be visible and clickable.
      When you click on the contact us heading, it is confirmed that GET IN TOUCH appears on the Contact Us page.
      When The visitor clicks the Send Message button without filling in the mandatory fields (your name, your, email, message) on the GET IN TOUCH page.
      Then Verify that prompts such as Please enter a valid name,Please enter a valid email address., Please enter a message with at least 10 characters. appear.
      And Closes the page.

  Scenario: TC03 Invalid Email Address Warning on GET IN TOUCH page

    Given user goes to the home page
    When The Contact Us banner at the top of the Welcome Page should be visible and clickable.
    When you click on the contact us heading, it is confirmed that GET IN TOUCH appears on the Contact Us page.
    When visitor enters valid username and message
    When The visitor enters an invalid email (with a missing @ symbol) and clicks the Send Message button.
    When Please enter a valid email address. message should be displayed
    Then Closes the page.

  Scenario: TC04 Text Message Alert on GET IN TOUCH page

    Given user goes to the home page
    When The Contact Us banner at the top of the Welcome Page should be visible and clickable.
    When you click on the contact us heading, it is confirmed that GET IN TOUCH appears on the Contact Us page.
    When visitor enters valid username and email
    When Visitor enters a message of less than 10 characters and clicks the Send Message button.
    When Please enter a message with at least 10 characters. message should be displayed
    Then Closes the page.

  Scenario: TC05 Validate that upon sending a message after entering required information, an alert confirming successful delivery is displayed.

    Given user goes to the home page
    When The Contact Us banner at the top of the Welcome Page should be visible and clickable.
    When you click on the contact us heading, it is confirmed that GET IN TOUCH appears on the Contact Us page.
    When visitors enter the required information and click the Send Message button
    When Confirm that after the visitor enters the necessary information and sends the message, the message Thanks for your message! It has been sent to us. is displayed.
    Then Closes the page.




