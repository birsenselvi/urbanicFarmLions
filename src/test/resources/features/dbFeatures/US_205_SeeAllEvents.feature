#As a user, when i should log in to my account then I Should be able to see all events that I created .
# Then I should able to connect DB
# and see all events in correct schema and columns in DB

@DB
@dbRegression
@UI
Feature:

  Scenario:TC_001
    Given user logs in api as SELLEROMER
    When user creates a new event for api
    Then user verifies that the new event has been created
    When user gets the all events details
    Then user verifies success true
    And the response body should contain details of all events
    Given user connects to the database
    When user should be able to see all events that user created
    Then user verifies following column names are present in DB "event" table
      | id    |
      | title |
    Then user verifies the created user events
    #And user deletes last event
