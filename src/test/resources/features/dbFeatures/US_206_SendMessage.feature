# As a user, when i should log in to my account then I Should be able to send a message.
# Then I should able to connect DB and see message that I send in correct schema and columns in DB
#Correct infos need to be seen in the correct columns.
#I should see user informations in the correct columns, eg : id: 135 owner_id;1484       content; hi Cristina

@US_206
@DB  @API
@dbRegression
Feature: US_206
  Scenario:US_206_TC_001-Login the page
    Given user logs in api as SELLEROMER
    When  user sends a message to Contact Us
    Then user verifies success true
  Scenario: US_206_TC_002-Verify Database
  Given user connects to the database
  When user should be able to see all message that user send
  Then userela verifies following column names are present in DB "message" table
  |id     |
  |content|
  Then user verifies the message that user send

  # Scenario:US_206_TC_002-Verify Database
#    Given user connects to the database
#    When user should be able to see all message that user send
#    Then user verifies following column names are present in DB "message" table
#      | id      |
#      | content |
#    Then user verifies the message that user send
