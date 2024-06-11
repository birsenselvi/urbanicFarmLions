#As a user, when i should add new product
# then I Should be able to see new product  in the correct  schema and columns in DB

@DB
@dbRegression
Feature:
  Scenario:TC_001 create new product, see the product and change status the product as approved and delete the product
    Given user creates new product from db
    And user sees the product from database
    When user changes status the product as approved
   # Then user deletes the product