@dbRegression  @US_204 @DB  @API
  Feature: Create a new event

    Scenario:US_204_TC_001 create new event
      Given user logs in api as SELLEROMER
      When user creates a new event for api
      Then user verifies that the new event has been created

    Scenario: US_204_TC_002 verify from DB
      Given user connects to the database
      When user should be able to see event that user created
      Then user verifies following column names are present in DB "event" table
        | id                   |
        | address_id           |
        | owner_id             |
        | title                |
        | date                 |
        | fee                  |
        | duration             |
        | attendee_limit       |
        | schedule             |
        | description          |
        | tac                  |
        | status               |
        | created              |
        | updated              |
        | is_active            |
        | is_refundable        |
        | refundable_up_to_day |

      Then user verifies the created user an event
      #And user deletes last record for event
