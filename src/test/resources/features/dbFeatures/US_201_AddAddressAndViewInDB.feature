#As a user, when i should add adress then I Should be able to see new adress
# in the correct user schema and columns in DB
# Correct infos need to be seen in the correct columns.
#I should see user informations in the correct columns, eg : city

@US_201  @dbRegression @DB  @API
Feature: US_201

  Scenario: US_201_TC_001 Add a new address

    Given user logs in api as SELLER
    When user add new Address
    Then User verifies that success is True

    Scenario: US_201_TC_002 verify from DB
    Given user connects to the database
    When user is able to see the created new address
    Then user verifies following column names are present in DB "address" table
      | id      |
      | title   |
      | address |
      | city    |
    Then user verifies the created address details
